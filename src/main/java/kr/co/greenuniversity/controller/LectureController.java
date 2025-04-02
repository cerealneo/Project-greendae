package kr.co.greenuniversity.controller;

import kr.co.greenuniversity.dto.LectureDTO;
import kr.co.greenuniversity.entity.College;
import kr.co.greenuniversity.entity.Lecture;
import kr.co.greenuniversity.entity.Professor;
import kr.co.greenuniversity.repository.CollegeRepository;
import kr.co.greenuniversity.service.LectureService;
import kr.co.greenuniversity.service.ProfessorService;
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
@Controller
@RequiredArgsConstructor
public class LectureController {

    private final ProfessorService professorService;
    private final CollegeRepository collegeRepository;
    private final LectureService lectureService;

    @GetMapping("/Management/ManageRegister")
    public String view(Model model) {

        List<College> colleges = collegeRepository.findAll();
        List<Professor> professors = professorService.findAllProfessors();
        model.addAttribute("colleges", colleges);
        model.addAttribute("professors", professors);

        return "/Management/ManageRegister";
    }

    @PostMapping("/Management/ManageRegister")
    public String registerLecture(@ModelAttribute Lecture lecture,
                                  @RequestParam String departmentName) {
            log.info("lecture={}", lecture);
        lectureService.registerLecture(lecture, departmentName);
        return "redirect:/Management/ManageRegister";

    }

}
