package kr.co.greenuniversity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollegeDTO {

    private int no;
    private String collegeName;
    private String college_eng_name;
    private String info_title;
    private String info_context;
    private String file;


}
