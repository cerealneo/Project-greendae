package kr.co.greenuniversity.entity;

import jakarta.persistence.Column;
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
    private String code;

    @Column(name = "dep_no")
    private String depNo;
    @Column(name = "col_name")
    private String colName;
    @Column(name = "dep_name")
    private String depName;

    private int grade;
    private int credit;
    private String division;
    private String pro_name;
    private String lec_name;
    private String lec_info;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "end_time")
    private String endTime;
    private String day;
    private String evaluation;
    private String book;
    private String classroom;
    private String people_num;


}
