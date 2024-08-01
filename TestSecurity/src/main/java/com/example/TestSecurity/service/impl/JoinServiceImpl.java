package com.example.TestSecurity.service.impl;

import com.example.TestSecurity.dto.JoinDTO;
import com.example.TestSecurity.entity.UserEntity;
import com.example.TestSecurity.repository.UserRepository;
import com.example.TestSecurity.service.JoinService;
//import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("joinService")
public class JoinServiceImpl implements JoinService {

    // db에 접근할 repository 및 엔티티
    @Autowired
//    @Resource(name="userRepository")
    private UserRepository userRepository;

    //autowired말고 명시적으로 선언
    @Resource(name="bCryptPasswordEncoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean joinProcess(JoinDTO dto) {
        boolean result = false;
        /**
         * 동일한 username을 가진 회원이 있는지 검증
         */

        UserEntity data = new UserEntity(); // 클래스 기반 객체 생성

        data.setUsername(dto.getUsername());
        data.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        data.setRole("ROLE_ADMN");

        userRepository.save(data);


        return result;
    }
}
