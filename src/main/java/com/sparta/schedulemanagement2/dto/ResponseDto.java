package com.sparta.schedulemanagement2.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ResponseDto {
    private Long id;
    private Long username;
    private String title;
    private String contents;
    private Date date;
    private Date fix_date;
    private Long commentcount;

    public ResponseDto(){}

    public ResponseDto(Long username, String title, String contents, Date date, Date fix_date) {
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.date = date;
        this.fix_date = fix_date;
    }
    public ResponseDto(String title, String contents,Long commentcount, Date date, Date fix_date, Long username) {
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.commentcount = commentcount;
        this.date = date;
        this.fix_date = fix_date;
    }
}
