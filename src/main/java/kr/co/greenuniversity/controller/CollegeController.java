package kr.co.greenuniversity.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.greenuniversity.dto.CollegeDTO;
import kr.co.greenuniversity.entity.College;
import kr.co.greenuniversity.repository.CollegeRepository;
import kr.co.greenuniversity.service.CollegeService;
import kr.co.greenuniversity.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class CollegeController {

    private final CollegeService collegeService;
    private final DepartmentService departmentService;
    private final CollegeRepository collegeRepository;

    @GetMapping("/Management/ManageDepartRegist")
    public String showPage(Model model) {
        List<College> colleges = collegeRepository.findAll();
        model.addAttribute("colleges", colleges); //
        return "Management/ManageDepartRegist"; //
    }

    @PostMapping("/Management/registerCollege")
    public String Departregister(HttpServletRequest req, CollegeDTO collegeDTO) {

        collegeService.registerCollege(collegeDTO);
        log.info("collegeDTO: {}", collegeDTO);


        return "redirect:/Management/ManageDepartregist";
    }


}
