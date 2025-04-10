package com.authentication.auth_service.controller;


import com.authentication.auth_service.entity.JwtJSON;
import com.authentication.auth_service.entity.UserEntity;
import com.authentication.auth_service.entity.UserPrincipal;
import com.authentication.auth_service.service.JwtService;
import com.authentication.auth_service.service.UserService;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth-service")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/user-register")
    public ResponseEntity<UserEntity> userRegister(@RequestBody UserEntity userEntity ){
        UserEntity newUser = userService.userRegister(userEntity);
        return  ResponseEntity.ok(newUser);
    }

    @PostMapping("/user-login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserEntity userEntity){
        String jwt =userService.verify(userEntity);
        Map<String, Object> jsonJwt = new HashMap<>();
        jsonJwt.put("token", jwt);
        return ResponseEntity.ok(jsonJwt);
    }

    @GetMapping("/user-verify-jwt")
    public String verifyJwt(){
        return "JWT autenticado";
    }








}
