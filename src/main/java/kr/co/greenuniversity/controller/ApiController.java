package kr.co.greenuniversity.controller;

import kr.co.greenuniversity.entity.Department;
import kr.co.greenuniversity.repository.DepartmentRepository;
import kr.co.greenuniversity.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final DepartmentRepository departmentRepository;
    private final ProfessorService professorService;

    public ApiController(DepartmentRepository departmentRepository, ProfessorService professorService) {
        this.departmentRepository = departmentRepository;
        this.professorService = professorService;
    }

    @GetMapping("/departments/by-college")
    public List<String> getDepartmentsByCollege(@RequestParam String collegeName) {
        List<Department> departments = departmentRepository.findByCollege_CollegeName(collegeName);
        return departments.stream()
                .map(Department::getDepartmentName)
                .collect(Collectors.toList());

    }

    @GetMapping("/generate-id")
    public Map<String, String> generateId(@RequestParam String departmentName) {
        String generatedId = professorService.generateProfessorIdPublic(departmentName);
        return Collections.singletonMap("id", generatedId);
    }
}
