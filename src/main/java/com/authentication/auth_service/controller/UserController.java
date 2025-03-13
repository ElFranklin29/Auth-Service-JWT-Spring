package com.authentication.auth_service.controller;


import com.authentication.auth_service.entity.UserEntity;
import com.authentication.auth_service.entity.UserPrincipal;
import com.authentication.auth_service.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth-service")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user-register")
    public UserEntity userRegister(@RequestBody UserEntity userEntity ){
        return  userService.userRegister(userEntity);
    }

    @PostMapping("/user-login")
    public String login(@RequestBody UserEntity userEntity){
        System.out.println("Soy endpoint uselogin");
        return userService.verify(userEntity);
    }

    @GetMapping("/greeting")
    public String greeting() {
        System.out.println("Hola");

        return "Hello world";
    }

}
