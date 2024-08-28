package com.sparta.schedulemanagement2.dto;

import com.sparta.schedulemanagement2.entity.Schedule;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentResponseDto {
    private Long id;
    private String comment;
    private String username;
    private Date date;
    private Date fix_date;
    private Long schedule_id;

    public CommentResponseDto(Long id, String comment, String username, Date date, Date fix_date, Long schedule_id) {
        this.id = id;
        this.comment = comment;
        this.username = username;
        this.date = date;
        this.fix_date = fix_date;
        this.schedule_id = schedule_id;
    }

}
