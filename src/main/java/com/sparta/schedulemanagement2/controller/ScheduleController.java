package com.sparta.schedulemanagement2.controller;

import com.sparta.schedulemanagement2.dto.RequestDto;
import com.sparta.schedulemanagement2.dto.ResponseDto;
import com.sparta.schedulemanagement2.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api")
@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;


    //일정 등록
    @PostMapping("/regist")
    public ResponseDto registschedule(RequestDto req){
        return scheduleService.registschedule(req);
    }

    //일정 단건 조회
    @GetMapping("/getone")
    public ResponseDto getschedule(RequestDto req){
        return scheduleService.getschedule(req);
    }

    //일정 수정
    @PutMapping("/modify")
    public ResponseDto modifyschedule(RequestDto req){
        return scheduleService.modifyschedule(req);
    }
}
