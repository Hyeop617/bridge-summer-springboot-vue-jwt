package com.hyeop.bridgesummer.web;

import com.hyeop.bridgesummer.service.UserService;
import com.hyeop.bridgesummer.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserApiController {

    @Autowired
    UserService userService;

    @PostMapping("/api/signup")
    public ResponseEntity signup(@RequestBody UserDto userDto) {
        return userService.signup(userDto);
    }

    @PostMapping("/api/login")
    public ResponseEntity login(@RequestBody UserDto userDto){
        return userService.login(userDto);
    }


}
