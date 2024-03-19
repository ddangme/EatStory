package com.ddangme.eatstory.service;

import com.ddangme.eatstory.domain.User;
import com.ddangme.eatstory.dto.UserDto;
import com.ddangme.eatstory.dto.request.UserJoinRequest;
import com.ddangme.eatstory.dto.request.UserLoginRequest;
import com.ddangme.eatstory.exception.EatStoryException;
import com.ddangme.eatstory.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Value;
import com.ddangme.eatstory.repository.UserRepository;
import com.ddangme.eatstory.utils.JwtTokenUtil;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;


    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.token.expired-time-ms}")
    private Long expiredTimeMs;

    public String login(UserLoginRequest request) {
        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new EatStoryException(ErrorCode.USER_NOT_FOUND, String.format("%s not founded", request.getUserId())));

        if (!user.getPassword().equals(request.getUserPassword())) {
            throw new EatStoryException(ErrorCode.MISMATCH_PASSWORD);
        }
//        if (!encoder.matches(request.getUserPassword(), user.getPassword())) {
//            throw new EatStoryException(ErrorCode.MISMATCH_PASSWORD);
//        }
        System.out.println("hihi");
        return JwtTokenUtil.generatedToken(request.getUserId(), secretKey, expiredTimeMs);
    }

    @Transactional
    public UserDto join(UserJoinRequest request) {
        User user = userRepository.save(User.join(request.getUserId(), request.getUserPassword()));

//        User user = userRepository.save(User.join(request.getUserId(), encoder.encode(request.getUserPassword())));

        return UserDto.fromEntity(user);
    }

    public boolean existUserId(String userId) {
        return userRepository.findByUserId(userId).isPresent();
    }

    public UserDto loadUserByUserName(String userName) {
        return userRepository.findByUserId(userName).map(UserDto::fromEntity).orElseThrow(() ->
                new EatStoryException(ErrorCode.USER_NOT_FOUND, String.format("%s not founded", userName)));
    }

}
