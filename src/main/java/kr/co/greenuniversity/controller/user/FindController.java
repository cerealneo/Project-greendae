package kr.co.greenuniversity.controller.user;

import jakarta.servlet.http.HttpSession;
import kr.co.greenuniversity.dto.user.UserDTO;
import kr.co.greenuniversity.entity.user.User;
import kr.co.greenuniversity.repository.user.UserRepository;
import kr.co.greenuniversity.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Controller
public class FindController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/findId")
    public String findId() {

        return "/user/findId";
    }

    @PostMapping("/findId")
    public String findId(UserDTO userDTO, Model model) {
        //User user = userService.findUserId(userDTO);

        /*if (user != null) {
            model.addAttribute("userName", user.getId());
            return "/user/ResultId"; // 결과 페이지로 이동
        } else {
            model.addAttribute("errorMessage", "입력한 이메일과 일치하는 아이디가 없습니다.");
            return "/user/findId"; // 다시 입력 폼으로 이동
        }*/

        Optional<User> optUser = userRepository.findByEmail(userDTO.getEmail());

        if (optUser.isPresent()) {
            User user = optUser.get();
            log.info("찾은 유저: {}", user);

            model.addAttribute("foundUserId", user.getId()); // ID 값을 모델에 추가
            return "/user/resultId"; // 결과 페이지로 이동
        }

        model.addAttribute("error", "해당 이메일로 등록된 계정이 없습니다.");
        return "/user/findId"; // 이메일이 없으면 다시 폼으로 이동
    }

    @GetMapping("/find/{type}/{value}")
    public ResponseEntity user(@PathVariable("type") String type, @PathVariable("value") String value){
        log.info("type : " + type + ", value : " + value);

        // 서비스 호출
        long count = userService.checkEmail(type, value);
        log.info("count : " + count);

        // JSON 생성
        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("count", count);
        log.info("count : " + count);

        // JSON 반환
        return ResponseEntity.ok().body(resultMap);
    }

    @PostMapping("/find/email/auth")
    public ResponseEntity<Boolean> emailAuth(@RequestBody Map<String,String> map, HttpSession session){ // JSON 단일 문자열값이 직접 String으로 매핑되지 않기 때문에 JSON과 호환되는 Map 타입으로 JSON 수신

        String authCode = map.get("authCode");
        log.info("authCode : {}", authCode);

        String sessAuthCode = (String) session.getAttribute("authCode");
        log.info("sessAuthCode : {}", sessAuthCode);

        if(authCode.equals(sessAuthCode)){
            return ResponseEntity
                    .ok()
                    .body(true);
        }
        return ResponseEntity
                .ok()
                .body(false);
    }

}
