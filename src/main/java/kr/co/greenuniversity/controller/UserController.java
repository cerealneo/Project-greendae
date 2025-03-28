package kr.co.greenuniversity.controller;

import kr.co.greenuniversity.dto.user.TermsDTO;
import kr.co.greenuniversity.service.user.TermsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final TermsService termsService;

    @GetMapping("/user/login")
    public String login(){
        return"/user/login";
    }

    @GetMapping("/user/terms")
    public String terms(Model model) {

        TermsDTO termsDTO = termsService.terms();
        model.addAttribute(termsDTO);

        return "/user/terms";
    }

    @GetMapping("/user/register")
    public String userRegister() {

        return "/user/userRegister";
    }



}
