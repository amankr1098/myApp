package com.myapp.usermangement.controller;

import com.myapp.common.requestPyload.LoginUser;
import com.myapp.common.requestPyload.RegisterUser;
import com.myapp.common.responseDto.ApiResponse;
import com.myapp.usermangement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
     public ResponseEntity registerUser(@RequestBody RegisterUser registerUser){
        ApiResponse apiResponse = userService.registerUser(registerUser);
        ResponseEntity response = new ResponseEntity<>(apiResponse, apiResponse.getStatus());
        return response;
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody LoginUser loginUser){
        ApiResponse response = userService.loginUser(loginUser);
        ResponseEntity responseEntity =new ResponseEntity<>(response,response.getStatus());
        return responseEntity;
    }
}
