package com.sparta.schedulemanagement2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private String username;
    private String email;
    private Date date;
    private Date fixdate;
}
