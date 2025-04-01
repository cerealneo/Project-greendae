package kr.co.greenuniversity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Lecture")
public class Lecture {

    @Id
    private int code;

    private String dep_no;
    private String col_name;
    private String dep_name;
    private int grade;
    private int credit;
    private String division;
    private String pro_name;
    private String lec_name;
    private String lec_info;
    private String start_date;
    private String end_date;
    private String start_time;
    private String end_time;
    private String day;
    private String evaluation;
    private String book;
    private String classroom;
    private String people_num;


}
