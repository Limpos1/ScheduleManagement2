package com.sparta.schedulemanagement2.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.schedulemanagement2.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long user_id;
    private String user_name;
    private String eamil;

    @JsonIgnore
    private List<User> us;
    @JsonIgnore
    private int index=0;

    public UserDto(List<User> us) {
        this.us = us;
    }

    public List<UserDto> setting(){
        List<UserDto> uDtos = new ArrayList<UserDto>();
        for (User u : us) {
            uDtos.add(new UserDto(us));
            uDtos.get(index).setUser_id(u.getUser_id());
            uDtos.get(index).setUser_name(u.getUsername());
            uDtos.get(index).setEamil(u.getEmail());
            index++;
        }
        return uDtos;
    }
}
