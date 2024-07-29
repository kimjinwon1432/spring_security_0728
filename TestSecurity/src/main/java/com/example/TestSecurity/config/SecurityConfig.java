package com.example.TestSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    // 패스워드 암호화 메소드
    @Bean("bCryptPasswordEncoder")
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        // 특정 경로에 대한 인가 작업
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/login", "/join", "/joinProc").permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/my/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .anyRequest().authenticated()
                );
        // form 로그인
        http
                .formLogin((auth) -> auth.loginPage("/login") // 권한이 없을 시 리다이렉트 시킴
                        .loginProcessingUrl("/loginProc") // 이 겅로로 로그인처리 진행
                        .permitAll()
                );

        // csrf 비활성화
        http
                .csrf((auth) -> auth.disable());

        return http.build();
    }
}
