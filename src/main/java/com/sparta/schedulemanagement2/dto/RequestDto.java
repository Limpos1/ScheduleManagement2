package com.sparta.schedulemanagement2.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestDto {
    private Long id;
    private Long user_id;
    private String title;
    private String contents;
}
