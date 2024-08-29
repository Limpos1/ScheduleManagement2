package com.sparta.schedulemanagement2.dto;

import com.sparta.schedulemanagement2.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDto {
    private Long id;
    private Long user_id;
    private String title;
    private String contents;
    private Date date;
    private Date fix_date;
    private Long commentcount;
    private List<UserDto> members;


    public ResponseDto(Long user_id, String title, String contents, Date date, Date fix_date) {
        this.user_id = user_id;
        this.title = title;
        this.contents = contents;
        this.date = date;
        this.fix_date = fix_date;
    }
    public ResponseDto(String title, String contents,Long commentcount, Date date, Date fix_date, Long user_id) {
        this.user_id = user_id;
        this.title = title;
        this.contents = contents;
        this.commentcount = commentcount;
        this.date = date;
        this.fix_date = fix_date;
    }

}
