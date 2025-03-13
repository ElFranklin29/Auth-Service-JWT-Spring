package com.authentication.auth_service.service;

import com.authentication.auth_service.entity.UserEntity;
import com.authentication.auth_service.entity.UserPrincipal;
import com.authentication.auth_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserServiceDetails implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);

        if (user == null){
            System.out.println("User not found");
            throw  new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(user);
    }
}
