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
    @JoinColumn(name = "college_name", referencedColumnName = "college_name")
    private College college;

    private String department_name;
    private String department_eng_name;
    private String establishment_date;
    private String pro_name;
    private String dep_number;
    private String office;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Professor_id")
    private Professor professor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "lecture_code", nullable = true)
    private Lecture lecture;


}
