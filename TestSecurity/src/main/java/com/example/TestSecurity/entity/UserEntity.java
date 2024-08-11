package com.example.TestSecurity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

import java.util.Collection;

// user의 entity임을 알리는 어노테이션.. 유저 정보를 담을 바구니라고 생각하면됨.
@Entity
@Setter
@Getter
public class UserEntity implements UserDetails {
    // entitu는 id값이 필수적으로 필요
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // db 테이블에 저장될 필드
    private String username;
    private String password;

    // 권한 저장을 위한 role
    private String role;
    /**
     * 계정 권한(Spring security Role)
     */
    private Set<GrantedAuthority> authorities;
    /* Getter/Setter */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
//        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
    }
}
