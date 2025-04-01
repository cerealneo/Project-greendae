package kr.co.greenuniversity.controller;

import kr.co.greenuniversity.dto.ProfessorDTO;
import kr.co.greenuniversity.entity.Professor;
import kr.co.greenuniversity.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping("/Management/ManageProfessor")
    public String view(){
        return "/Management/ManageProfessor";
    }

    @PostMapping("/Management/ManageProfessor")
    public String registerProfessor(Professor professor) {
        professorService.registerProfessor(professor);
        return "redirect:/Management/ManageProfessor";

    }


}
