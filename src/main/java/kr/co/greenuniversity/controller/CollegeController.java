package kr.co.greenuniversity.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.greenuniversity.dto.CollegeDTO;
import kr.co.greenuniversity.entity.College;
import kr.co.greenuniversity.service.CollegeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class CollegeController {

    private final CollegeService collegeService;

    @GetMapping("/Management/ManageDepartregist")
    public String Departregister(){
        return "/Management/ManageDepartregist";
    }
    @PostMapping("/Management/ManageDepartregist")
    public String Departregister(HttpServletRequest req, CollegeDTO collegeDTO) {

        collegeService.registerCollege(collegeDTO);
        log.info("collegeDTO: {}", collegeDTO);


        return "redirect:/Management/ManageDepartregist";
    }
}
