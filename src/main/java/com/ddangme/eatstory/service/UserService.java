package com.ddangme.eatstory.service;

import com.ddangme.eatstory.domain.User;
import com.ddangme.eatstory.dto.UserDto;
import com.ddangme.eatstory.dto.request.UserJoinRequest;
import com.ddangme.eatstory.dto.request.UserLoginRequest;
import com.ddangme.eatstory.exception.EatStoryException;
import com.ddangme.eatstory.exception.ErrorCode;
import com.ddangme.eatstory.repository.UserRepository;
import com.ddangme.eatstory.utils.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;


    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.token.expired-time-ms}")
    private Long expiredTimeMs;

    @Override
    public UserDto loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserId(username)
                .map(UserDto::fromEntity)
                .orElseThrow(() ->
                        new EatStoryException(ErrorCode.USER_NOT_FOUND));
    }

    public String login(UserLoginRequest request) {
        UserDto response = loadUserByUsername(request.getUserId());

        if (!encoder.matches(request.getUserPassword(), response.getPassword())) {
            throw new EatStoryException(ErrorCode.INVALID_PASSWORD);
        }

        return JwtTokenUtil.generateAccessToken(request.getUserId(), secretKey, expiredTimeMs);
    }

    @Transactional
    public UserDto join(UserJoinRequest request) {
        userRepository.findByUserId(request.getUserId())
                .ifPresent(it -> {
                    throw new EatStoryException(ErrorCode.DUPLICATED_USER_NAME);
                });

        if (!request.getUserPassword().equals(request.getUserPasswordCheck())) {
            throw new EatStoryException(ErrorCode.MISMATCH_PASSWORD);
        }

        User joinUser = userRepository.save(User.join(request.getUserId(), encoder.encode(request.getUserPassword())));

        return UserDto.fromEntity(joinUser);
    }

    public Optional<UserDto> searchUser(String userId) {
        return userRepository.findByUserId(userId)
                .map(UserDto::fromEntity);
    }

}
