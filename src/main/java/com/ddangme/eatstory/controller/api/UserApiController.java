package com.ddangme.eatstory.controller.api;

import com.ddangme.eatstory.controller.Response;
import com.ddangme.eatstory.dto.request.UserJoinRequest;
import com.ddangme.eatstory.dto.request.UserLoginRequest;
import com.ddangme.eatstory.dto.response.UserLoginResponse;
import com.ddangme.eatstory.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/join")
    public Response<Void> join(@RequestBody UserJoinRequest userJoinRequest) {
        userService.join(userJoinRequest);

        return Response.success();
    }

    @PostMapping("/login")
    public Response<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest) {
        String token = userService.login(userLoginRequest);

        return Response.success(new UserLoginResponse(token));
    }
}
