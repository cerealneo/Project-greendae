package kr.co.greenuniversity.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {


    //필요 시 수정 후 사용
    /*
        // 비밀번호 암호화
        String encodedPass= passwordEncoder.encode(userDTO.getPass());
        userDTO.setPass(encodedPass);

        //엔티티 변환
        User user= modelMapper.map(userDTO, User.class);

        User savedUser= userRepository.save(user);

        long count = 0;

        if (type.equals("uid")){
            count = userRepository.countByUid(value);
        }else if (type.equals("nick")){
            count = userRepository.countByNick(value);
        }else if (type.equals("email")){
            count = userRepository.countByEmail(value);

            if (count == 0){
                String code = sendEmailCode(value);

                //인증코드 비교를 하기 위해서 세션 저장
                session.setAttribute("authCode", code);

            }
        }else if (type.equals("hp")) {
            count = userRepository.countByHp(value);
        }
        return count;
    }

    @Value("${spring.mail.username}")
    private String sender;
    public String sendEmailCode(String receiver){

        //MimeMessage 생성
        MimeMessage message = mailSender.createMimeMessage();

        //인증코드 생성
        int code = ThreadLocalRandom.current().nextInt(100000, 1000000);
        log.info("code : " + code);

        String subject = "sboard 인증코드 안내";
        String content = "<h1>sboard 인증코드는 " + code + "</h1>";

        try {
            message.setFrom(new InternetAddress(sender, "보내는 사람", "UTF-8"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject(subject);
            message.setContent(content, "text/html;charset=UTF-8");

            //메일 발송
            mailSender.send(message);

        }catch (Exception e){
            log.error(e.getMessage());
        }

        return String.valueOf(code);

    }
     */
}
