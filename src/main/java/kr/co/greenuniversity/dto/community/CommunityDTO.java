package kr.co.greenuniversity.dto.community;

import kr.co.greenuniversity.dto.FileDTO;
import kr.co.greenuniversity.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommunityDTO {
    private int no;
    private String cate;
    private String title;
    private String content;
    private int comment;
    private int file;
    private int hit;
    private String writer;
    private String regip;
    private String wdate;

    // 추가 컬럼
    private String name;
    private UserDTO user;

    public String getWdate() {
        if(wdate != null){
            return wdate.substring(0, 10);
        }
        return null;
    }


}
