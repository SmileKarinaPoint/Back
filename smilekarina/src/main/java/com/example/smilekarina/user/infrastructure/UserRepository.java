package com.example.smilekarina.user.infrastructure;

import com.example.smilekarina.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginId(String loginId);
    User findByUUID(String UUID);
}
