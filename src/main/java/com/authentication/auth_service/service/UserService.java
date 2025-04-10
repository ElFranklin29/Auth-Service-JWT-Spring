package com.authentication.auth_service.service;

import com.authentication.auth_service.entity.UserEntity;
import com.authentication.auth_service.exception.AuthenticationException;
import com.authentication.auth_service.exception.IncorrectFormatPassword;
import com.authentication.auth_service.exception.UsernameAlreadyExist;
import com.authentication.auth_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authManage;

    @Autowired
    private JwtService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserEntity userRegister(UserEntity userEntity) {

        if (userRepository.existsByUsername(userEntity.getUsername())) {
            throw new UsernameAlreadyExist("Este email ya se encuentra registrado, ingrese uno nuevo o inicie sesion");
        }

        if (!validatePassword(userEntity.getPassword())){
            System.out.println("Hola soy validate password");
            throw new IncorrectFormatPassword("La contraseña debe contener 8 carcateres, al menos una mayuscula y al menos un numero");

        }

        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);

    }


    public String verify(UserEntity userEntity) {

        if (!userRepository.existsByUsername(userEntity.getUsername()) || !verifyAuthentication(userEntity)) {
            throw new AuthenticationException("El correo o la contraseña ingresados no son correctos");
        }
        Authentication authentication = authManage.
                authenticate(new UsernamePasswordAuthenticationToken(userEntity.getUsername(), userEntity.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(userEntity.getUsername());
        }

        return "fail";

    }

    private Boolean verifyAuthentication(UserEntity userEntity){

        String passwordEncrypted= userRepository.findByUsername(userEntity.getUsername()).getPassword();

        return encoder.matches(userEntity.getPassword(), passwordEncrypted );
    }

    private Boolean validatePassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)+[A-Za-z\\d@$!%*?&]{8,}$";

        if (!password.matches(passwordRegex)) {
            return false;
        }
        return true;
    }

}
