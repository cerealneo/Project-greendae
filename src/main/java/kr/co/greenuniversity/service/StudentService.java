package kr.co.greenuniversity.service;

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

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final DepartmentRepository departmentRepository;

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
        String prefix = year + deptNo;

        String lastId = studentRepository.findLastIdStartingWith(prefix);

        int nextSeq;
        if (lastId == null) {
            nextSeq = 1;
        } else {
            // 🔥 여기에서 정확하게 자르기 (prefix 길이만큼)
            String seqStr = lastId.substring(prefix.length()); // "01"
            nextSeq = Integer.parseInt(seqStr) + 1;
        }

        // 🔐 최종 학번: "20251202"
        return prefix + String.format("%02d", nextSeq);

    }


    public String generateStudentIdPublic(String departmentName) {

        Department dept = departmentRepository.findByDepartmentName(departmentName)
                .orElseThrow(() -> new IllegalArgumentException("학과 없음"));
        return generateStudentId(dept);
    }
}
