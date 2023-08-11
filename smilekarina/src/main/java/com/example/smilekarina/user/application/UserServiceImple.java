package com.example.smilekarina.user.application;

import com.example.smilekarina.user.domain.User;
import com.example.smilekarina.user.dto.UserGetDto;
import com.example.smilekarina.user.dto.UserSignUpDto;
import com.example.smilekarina.user.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImple implements UserService{

    private final UserRepository userRepository;

    @Override
    public void createUser(UserSignUpDto userSignUpDto) {

        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();

        User user = User.builder()
                .loginId(userSignUpDto.getLoginId())
                .UUID(uuidString)
                .userName(userSignUpDto.getName())
                .password(userSignUpDto.getPassword())
                .email(userSignUpDto.getEmail())
                .phone(userSignUpDto.getPhone())
                .address(userSignUpDto.getAddress())
                .status(1)
                .build();
        userRepository.save(user);
    }

    @Override
    public UserGetDto getUserByLoginId(String loginId) {

        User user = userRepository.findByLoginId(loginId);
        log.info("user is : {}" , user);
        UserGetDto userGetDto = UserGetDto.builder()
                .loginId(user.getLoginId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .address(user.getAddress())
                .build();
        return userGetDto;
    }

    @Override
    public UserGetDto getUserByUUID(String UUID) {
        User user = userRepository.findByUUID(UUID);
        log.info("user is : {}" , user);
        UserGetDto userGetDto = UserGetDto.builder()
                .loginId(user.getLoginId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .address(user.getAddress())
                .build();
        return userGetDto;
    }

    @Override
    public List<UserGetDto> getAllUsers() {
        return null;
    }
}