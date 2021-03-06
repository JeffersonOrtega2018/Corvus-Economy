package com.finanzas.controller;

import com.finanzas.converter.UserConverter;
import com.finanzas.dto.*;
import com.finanzas.entities.User;
import com.finanzas.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {
    private final UserService userService;

    private final UserConverter userConverter;

    public LoginController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody  SignupRequestDto signupRequestDto) {
        User user = userService.registerUser(signupRequestDto);
        return new ResponseEntity<UserDto>(userConverter.convertEntityToDto(user), HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<LoginResponseDto> authenticateUser(@Valid @RequestBody LoginRequestDto request){
        LoginResponseDto loginResponseDto=userService.authenticateUser(request);
        return new ResponseEntity<LoginResponseDto>(loginResponseDto, HttpStatus.OK);
    }

}

