package com.example.TestSecurity.controller;

import com.example.TestSecurity.entity.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(Model model, Authentication auth){

        UserEntity entity = (UserEntity) auth.getPrincipal();
        model.addAttribute(entity.getId());
        return "main";
    }
}
