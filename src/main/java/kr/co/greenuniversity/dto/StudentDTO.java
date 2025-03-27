package kr.co.greenuniversity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {

    private int id;
    private String name;
    private String jumin;
    private String eng_name;
    private String gender;
    private String nationality;
    private String phone;
    private String email;
    private String addr1;
    private String addr2;
    private String reg_year;
    private String classification;
    private String end_year;
    private String college_name;
    private String department_name;
    private String pro_name;
    private String reg_grade;
    private String reg_term;
    private String status;


}
