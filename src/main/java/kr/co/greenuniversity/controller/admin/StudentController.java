package kr.co.greenuniversity.controller.admin;

import kr.co.greenuniversity.dto.StudentDTO;
import kr.co.greenuniversity.entity.College;
import kr.co.greenuniversity.entity.Department;
import kr.co.greenuniversity.entity.Professor;
import kr.co.greenuniversity.entity.Student;
import kr.co.greenuniversity.repository.CollegeRepository;
import kr.co.greenuniversity.repository.DepartmentRepository;
import kr.co.greenuniversity.repository.StudentRepository;
import kr.co.greenuniversity.service.admin.DepartmentService;
import kr.co.greenuniversity.service.admin.ProfessorService;
import kr.co.greenuniversity.service.admin.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;
    private final DepartmentService departmentService;
    private final ProfessorService professorService;
    private final DepartmentRepository departmentRepository;
    private final CollegeRepository collegeRepository;


    @GetMapping("/Management/ManageStdRegister")
    public String showStudentForm(Model model) {

        List<College> colleges = collegeRepository.findAll();
        model.addAttribute("colleges", colleges);

        List<Professor> professors = professorService.findAllProfessors();
        model.addAttribute("professors", professors);

        if (!colleges.isEmpty() && !colleges.get(0).getDepartments().isEmpty()) {
            Department defaultDept = colleges.get(0).getDepartments().get(0);
            String generatedId = professorService.generateProfessorId(defaultDept);
            model.addAttribute("generatedId", generatedId); // <-- View에 전달
        }

        return "/Management/ManageStdRegister";
    }

    @PostMapping("/Management/ManageStdRegister")
    public String registerStudent(@ModelAttribute Student student,
                                  @RequestParam String departmentName) {

        studentService.registerStudent(student, departmentName);
        log.info("Student {}", student);

        return "redirect:/Management/ManageStdRegister";
    }

    @GetMapping("/Management/StdList")
    public String StudentList(Model model) {

        List<StudentDTO> stdList = studentService.StdfindAll();
        model.addAttribute("stdList", stdList);

        return "/Management/ManageStdList";
    }
}
