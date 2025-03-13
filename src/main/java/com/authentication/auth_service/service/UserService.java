package com.authentication.auth_service.service;

import com.authentication.auth_service.entity.UserEntity;
import com.authentication.auth_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authManage;

    @Autowired
    private JwtService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserEntity userRegister(UserEntity userEntity){

        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);
    }


    public String verify(UserEntity userEntity) {
        System.out.println("Soy verify");
        Authentication authentication = authManage.
                authenticate(new UsernamePasswordAuthenticationToken(userEntity.getUsername(), userEntity.getPassword()));

        if (authentication.isAuthenticated()){
            return jwtService.generateToken(userEntity.getUsername());
        }

        return "fail";

    }
}
