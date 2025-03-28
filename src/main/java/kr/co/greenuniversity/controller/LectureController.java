package kr.co.greenuniversity.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.greenuniversity.dto.LectureDTO;
import kr.co.greenuniversity.service.LectureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LectureController {

    private final LectureService lectureService;

    @GetMapping("/Management/ManageDepartRegist")
    public String lecRegister(){
        return "/Management/ManageDepartRegist";
    }

    @PostMapping("/Management/ManageDepartRegist")
    public String lecRegister(HttpServletRequest req, LectureDTO lectureDTO) {

        lectureService.registerLecture(lectureDTO);
        log.info("lectureDTO: {}", lectureDTO);

        return "redirect:/Management/ManageDepartregist";
    }
}
