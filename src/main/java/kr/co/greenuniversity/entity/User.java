package kr.co.greenuniversity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "User")
public class User {

    @Id
    private String id;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String addr1;
    private String addr2;
    private String role;

}
