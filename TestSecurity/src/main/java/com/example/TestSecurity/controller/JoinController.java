package com.example.TestSecurity.controller;

import com.example.TestSecurity.dto.JoinDTO;
import com.example.TestSecurity.service.JoinService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {

//    @Autowired
//    private JoinService joinService;
    private final JoinService joinService;
    public JoinController(JoinService joinService){
        this.joinService = joinService;
    }

    @GetMapping("/join")
    public String joinP(){
        return "join";
    }

    @PostMapping("/joinProc")
    public String joinProcess(JoinDTO dto){
        System.out.println(dto.toString());

        joinService.joinProcess(dto);

        return "redirect:/login";
    }
}
