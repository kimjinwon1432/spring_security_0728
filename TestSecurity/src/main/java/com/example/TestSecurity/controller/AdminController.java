package com.example.TestSecurity.controller;

import com.example.TestSecurity.dto.CustomUserDetails;
import com.example.TestSecurity.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class AdminController {
    @GetMapping("/admin")
    public String adminP(Authentication auth){
        CustomUserDetails entity = null;

        try {
            entity = (CustomUserDetails) auth.getPrincipal();
        } catch( Exception e ){
            e.printStackTrace();;
        }
        System.out.println(entity);
        return "admin";
    }
}
