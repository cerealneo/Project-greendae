package kr.co.greenuniversity.controller;

import kr.co.greenuniversity.dto.StudentDTO;
import kr.co.greenuniversity.repository.StudentRepository;
import kr.co.greenuniversity.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;


    @GetMapping("/Management/ManageStdRegister")
    public String viewStudent() {
        return "/Management/ManageStdRegister";
    }

    @PostMapping("/Management/ManageStdRegister")
    public String registerStudent(StudentDTO studentDTO) {

        studentService.registerStudent(studentDTO);
        log.info("Student {}", studentDTO);

        return "redirect:/Management/ManageStdRegister";

    }
}
