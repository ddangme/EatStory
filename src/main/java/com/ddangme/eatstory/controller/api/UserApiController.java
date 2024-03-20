package com.ddangme.eatstory.controller.api;

import com.ddangme.eatstory.controller.Response;
import com.ddangme.eatstory.dto.request.UserJoinRequest;
import com.ddangme.eatstory.dto.request.UserLoginRequest;
import com.ddangme.eatstory.dto.response.UserLoginResponse;
import com.ddangme.eatstory.exception.EatStoryException;
import com.ddangme.eatstory.exception.ErrorCode;
import com.ddangme.eatstory.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/join")
    public Response<Void> join(@RequestBody UserJoinRequest userJoinRequest) {

        log.info("userId: {}, userPw: {}, userPwc: {}", userJoinRequest.getUserId(), userJoinRequest.getUserPassword(), userJoinRequest.getUserPasswordCheck());
        userService.join(userJoinRequest);

        return Response.success();
    }

    @PostMapping("/login")
    public Response<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest) {
        String token = userService.login(userLoginRequest);

        return Response.success(new UserLoginResponse(token));
    }
}
