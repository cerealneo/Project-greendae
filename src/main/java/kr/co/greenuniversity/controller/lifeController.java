package kr.co.greenuniversity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class lifeController {
    @GetMapping("/life/council")
    public String council() {
        return "/life/council";
    }
    @GetMapping("/life/galary")
    public String galary() {
        return "/life/galary";
    }
    @GetMapping("/life/meal")
    public String meal() {
        return "/life/meal";
    }
    @GetMapping("/life/study")
    public String study() {
        return "/life/study";
    }


}
