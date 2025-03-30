package kr.co.greenuniversity.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.greenuniversity.dto.user.TermsDTO;
import kr.co.greenuniversity.dto.user.UserDTO;
import kr.co.greenuniversity.service.user.TermsService;
import kr.co.greenuniversity.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final TermsService termsService;

    private final UserService userService;

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

    @PostMapping("/user/register")
    public String userRegister(UserDTO userDTO) {
        log.info("userDTO: {}", userDTO);
        userService.userRegister(userDTO);

        return "redirect:/user/login";
    }





}
