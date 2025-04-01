package kr.co.greenuniversity.service;

import kr.co.greenuniversity.entity.Department;
import kr.co.greenuniversity.entity.Professor;
import kr.co.greenuniversity.repository.DepartmentRepository;
import kr.co.greenuniversity.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfessorService {


    private final ProfessorRepository professorRepository;
    private final ModelMapper modelMapper;
    private final DepartmentRepository departmentRepository;

    public void registerProfessor(Professor professor, String departmentName) {

        Department department = departmentRepository.findByDepartmentName(departmentName)
                .orElseThrow(() -> new IllegalArgumentException("Department not found"));

        String generatedId = generateProfessorId(department);
        professor.setId(generatedId);

        // 저장
        professorRepository.save(professor);
    }

    public String generateProfessorId(Department department) {

        String year = String.valueOf(LocalDate.now().getYear());
        String deptNo = String.format("%02d", department.getNo());
        int count = professorRepository.countByDepartment(department);
        String seq = String.format("%02d", count + 1);

        return year + deptNo + seq;

    }


    public String generateProfessorIdPublic(String departmentName) {

        Department dept = departmentRepository.findByDepartmentName(departmentName)
                .orElseThrow(() -> new IllegalArgumentException("학과 없음"));
        return generateProfessorId(dept);
    }
}
