package kr.co.greenuniversity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Professor")
public class Professor {


    @Id
    private int id;

    private String jumin;
    private String name;
    private String eng_name;
    private String gender;
    private String phone;
    private String nationality;
    private String email;
    private String addr1;
    private String addr2;
    private String gradColName;
    private String major;
    private String end_date;
    private String degree;
    private String spot;
    private String college_name;

    @Column(name = "department_name")
    private String departmentName;

    private String appointment_date;
    private String empoly_status;


    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private List<Department> departments;
}
