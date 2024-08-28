package com.sparta.schedulemanagement2.controller;

import com.sparta.schedulemanagement2.dto.UserRequestDto;
import com.sparta.schedulemanagement2.dto.UserResponseDto;
import com.sparta.schedulemanagement2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/regist")
    public String registerUser(UserRequestDto req) {
        return userService.registerUser(req);
    }

    @GetMapping("/get")
    public UserResponseDto getUser(@RequestParam Long user_id) {
        return userService.getUser(user_id);
    }

    @GetMapping("/allget")
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/modify")
    public UserResponseDto modifyUser(UserRequestDto req) {
        return userService.modifyUser(req);
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam Long user_id) {
        return userService.deleteUser(user_id);
    }
}
