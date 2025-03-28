package kr.co.greenuniversity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
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

    private LocalDateTime start_date;
    private LocalDateTime end_date;

    private String start_time;
    private String end_time;
    private String day;
    private String evaluation;
    private String book;
    private String classroom;
    private String people_num;


}
