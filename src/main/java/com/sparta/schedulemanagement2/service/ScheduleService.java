package com.sparta.schedulemanagement2.service;


import com.sparta.schedulemanagement2.dto.RequestDto;
import com.sparta.schedulemanagement2.dto.ResponseDto;
import com.sparta.schedulemanagement2.entity.Schedule;
import com.sparta.schedulemanagement2.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public ResponseDto registschedule(RequestDto requestDto) {
        Date date = new Date();

        Schedule s = new Schedule();
        s.setUsername(requestDto.getUsername());
        s.setTitle(requestDto.getTitle());
        s.setContents(requestDto.getContents());
        s.setDate(date);
        s.setFixdate(date);

        s = scheduleRepository.save(s);
        ResponseDto r = new ResponseDto(s.getUsername(),s.getTitle(),s.getContents(),s.getDate(),s.getFixdate());

        return r;

    }

    public ResponseDto getschedule(RequestDto requestDto) {
        Schedule schedule;
        Long id = requestDto.getId();
        Optional<Schedule> s = scheduleRepository.findById(id);
        if (s.isPresent()) {
            schedule = s.get();
        }
        else{
            throw new RuntimeException("해당 일정은 없습니다.");
        }
        ResponseDto res = new ResponseDto(schedule.getUsername(),schedule.getTitle(),schedule.getContents(),schedule.getDate(),schedule.getFixdate());
        return res;
    }

    public ResponseDto modifyschedule(RequestDto req) {
        Date date = new Date();
        Schedule schedule;
        Long id = req.getId();
        Optional<Schedule> s = scheduleRepository.findById(id);
        if (s.isPresent()) {
            schedule = s.get();
            schedule.setTitle(req.getTitle());
            schedule.setContents(req.getContents());
            schedule.setFixdate(date);
            schedule = scheduleRepository.save(schedule);
        }
        else{
            throw new RuntimeException("해당 일정은 없습니다.");
        }
        ResponseDto r = new ResponseDto();
        r.setId(schedule.getId());
        r.setUsername(schedule.getUsername());
        r.setTitle(schedule.getTitle());
        r.setContents(schedule.getContents());
        r.setFix_date(schedule.getFixdate());

        return r;
    }
    public Page<ResponseDto> pageschedule(int pagenumber, int size) {
        Pageable pageable = PageRequest.of(pagenumber, size, Sort.by("fixdate").descending());
        Page<ResponseDto> schedules = scheduleRepository.findAllSchedules(pageable);

        return schedules;
    }

    public void deleteschedule(RequestDto req) {
        Schedule s = scheduleRepository.findById(req.getId()).orElseThrow(()->new RuntimeException("존재하지 않는 일정입니다."));
        scheduleRepository.delete(s);
    }
}
