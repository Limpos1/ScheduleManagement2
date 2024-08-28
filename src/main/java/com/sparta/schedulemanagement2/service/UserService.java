package com.sparta.schedulemanagement2.service;

import com.sparta.schedulemanagement2.dto.UserRequestDto;
import com.sparta.schedulemanagement2.dto.UserResponseDto;
import com.sparta.schedulemanagement2.entity.User;
import com.sparta.schedulemanagement2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String registerUser(UserRequestDto req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setDate(new Date());
        user.setFixdate(new Date());

        userRepository.save(user);
        return "유저 등록 성공";

    }

    public UserResponseDto getUser(Long userid) {
        User res = userRepository.findById(userid).orElseThrow(()->new RuntimeException("존재하지 않는 유저입니다."));
        UserResponseDto resDto = new UserResponseDto();
        resDto.setUsername(res.getUsername());
        resDto.setEmail(res.getEmail());
        resDto.setDate(res.getDate());
        resDto.setFixdate(res.getFixdate());

        return resDto;
    }

    public List<UserResponseDto> getAllUsers() {
        List<User> res = userRepository.findAll();
        return res.stream().
                map(user -> new UserResponseDto(user.getUsername(),user.getEmail(),user.getDate(),user.getFixdate()))
                .collect(Collectors.toList());
    }

    public UserResponseDto modifyUser(UserRequestDto req) {
        User u = userRepository.findById(req.getUser_id()).orElseThrow(()->new RuntimeException("존재하지 않는 유저입니다."));
        u.setEmail(req.getEmail());
        u.setUsername(req.getUsername());
        u.setFixdate(new Date());
        userRepository.save(u);
        UserResponseDto resDto = new UserResponseDto(u.getUsername(),u.getEmail(),u.getDate(),u.getFixdate());
        return resDto;
    }

    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "삭제 완료";
    }
}
