package kr.co.greenuniversity.service.admin;

import kr.co.greenuniversity.dto.StudentDTO;
import kr.co.greenuniversity.entity.Department;
import kr.co.greenuniversity.entity.Student;
import kr.co.greenuniversity.repository.DepartmentRepository;
import kr.co.greenuniversity.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final DepartmentRepository departmentRepository;

    public List<StudentDTO> StdfindAll() {

        return studentRepository.findAll().stream()
                .map(student -> modelMapper.map(student, StudentDTO.class)) // 변환
                .collect(Collectors.toList()); // 리스트로 변환
    }

    public void registerStudent(Student student, String departmentName) {

        Department department = departmentRepository.findByDepartmentName(departmentName)
                .orElseThrow(() -> new IllegalArgumentException("Department not found"));

        String generatedId = generateStudentId(department);
        student.setId(generatedId);

        if (!studentRepository.existsById(generatedId)) {
            studentRepository.save(student);  // insert 처리
        } else {
            throw new IllegalStateException("이미 존재하는 학번입니다: " + generatedId);
        }
    }

    public String generateStudentId(Department department) {

        String year = String.valueOf(LocalDate.now().getYear());
        String deptNo = String.format("%02d", department.getNo());
        int count = studentRepository.countByDepartment(department);
        String seq = String.format("%02d", count + 1);

        return year + deptNo + seq;

    }

    public String generateStudentIdPublic(String departmentName) {

        Department dept = departmentRepository.findByDepartmentName(departmentName)
                .orElseThrow(() -> new IllegalArgumentException("학과 없음"));
        return generateStudentId(dept);
    }
}
