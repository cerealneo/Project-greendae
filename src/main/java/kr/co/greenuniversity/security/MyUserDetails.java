package kr.co.greenuniversity.security;

import kr.co.greenuniversity.entity.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
public class MyUserDetails implements UserDetails {

    private User user;




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //권한 목록 생성
        List<GrantedAuthority> authorities = new ArrayList<>();
        //계정 권한 앞에 접두어 ROLE_ 붙여야 됨
        authorities.add(new SimpleGrantedAuthority("Role_" + user.getId()));
        return authorities;                                     //getUid -> get???변경필요(ex.role)
    }
    @Override
    public String getPassword() {
        return user.getId();
    }               //getPass로 변경해야함

    @Override
    public String getUsername() {
        return user.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        //계정 만료 여부(true : 만료안됨, false : 만료됨)
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //계정 잠김 여부
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //비밀번호 만료 여부
        return true;
    }

    @Override
    public boolean isEnabled() {
        //계정 활성화 여부
        return true;
    }


}

//수정 필요

