package kr.co.greenuniversity.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.naming.Name;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Department")
public class Department {

    @Id
    private int no;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_name")
    private College college;

    private String department_name;
    private String department_eng_name;
    private String establishment_date;
    private String pro_name;
    private String dep_number;
    private String office;
    private int lecture_code;
    private int Student_id;
    private int Professor_id;


}
