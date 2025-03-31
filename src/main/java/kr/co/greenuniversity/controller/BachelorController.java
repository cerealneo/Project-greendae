package kr.co.greenuniversity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BachelorController {

    @GetMapping("/Bachelor/BacGrad")
    public String BacGrad () {
        return "/Bachelor/BacGrad";
    }

    @GetMapping("/Bachelor/BacNotice")
    public String BacNotice () {
        return "/Bachelor/BacNotice";
    }

    @GetMapping("/Bachelor/BacQuestion")
    public String BacQuestion () {
        return "/Bachelor/BacQuestion";
    }

    @GetMapping("/Bachelor/BacResult")
    public String BacResult () {
        return "/Bachelor/BacResult";
    }

    @GetMapping("/Bachelor/BacSchedule")
    public String BacSchedule () {
        return "/Bachelor/BacSchedule";
    }

    @GetMapping("/Bachelor/BacSubscribe")
    public String BacSubscribe () {
        return "/Bachelor/BacSubscribe";
    }



}
