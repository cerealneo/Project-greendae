package kr.co.greenuniversity.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "College")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    private String college_name;
    private String college_eng_name;
    private String info_title;
    private String info_context;
    private String file;


}
