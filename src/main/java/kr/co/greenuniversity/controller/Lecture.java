package kr.co.greenuniversity.controller;

import kr.co.greenuniversity.entity.Professor;
import kr.co.greenuniversity.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class Lecture {

    private final ProfessorService professorService;

    @GetMapping("/Management/ManageRegister")
    public String view(Model model) {

        List<Professor> professors = professorService.findAllProfessors();
        model.addAttribute("professors", professors);

        return "/Management/ManageRegister";
    }

}
