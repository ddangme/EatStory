package com.ddangme.eatstory.service;

import com.ddangme.eatstory.domain.user.User;
import com.ddangme.eatstory.dto.UserDto;
import com.ddangme.eatstory.dto.request.UserJoinRequest;
import com.ddangme.eatstory.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;


    public Optional<UserDto> searchUser(String userId) {
        return userRepository.findByUserId(userId)
                .map(UserDto::fromEntity);
    }

    public boolean existUserId(String userId) {
        return userRepository.findByUserId(userId)
                .isPresent();
    }

    @Transactional
    public void signUp(UserJoinRequest request) {
        userRepository.save(User.join(request.getUserId(), encoder.encode(request.getPassword()), request.getNickname()));
    }



}
