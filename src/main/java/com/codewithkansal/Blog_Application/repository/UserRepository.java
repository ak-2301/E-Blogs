package com.codewithkansal.Blog_Application.repository;

import com.codewithkansal.Blog_Application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    Optional<User>findByUsernameOrEmail(String userName,String email);

    Optional<User>findByUsername(String userName);

    Boolean existsByUsername(String userName);

    Boolean existsByEmail(String email);
}
