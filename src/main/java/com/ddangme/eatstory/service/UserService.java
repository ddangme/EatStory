package com.ddangme.eatstory.service;

import com.ddangme.eatstory.dto.UserDto;
import com.ddangme.eatstory.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public Optional<UserDto> searchUser(String userId) {
        return userRepository.findByUserId(userId)
                .map(UserDto::fromEntity);
    }



}
