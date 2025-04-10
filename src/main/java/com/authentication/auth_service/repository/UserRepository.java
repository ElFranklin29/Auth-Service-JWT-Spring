package com.authentication.auth_service.repository;

import com.authentication.auth_service.entity.UserEntity;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
    Boolean existsByUsername(String username);

}
