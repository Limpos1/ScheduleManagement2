package com.sparta.schedulemanagement2.service;


import com.sparta.schedulemanagement2.dto.RequestDto;
import com.sparta.schedulemanagement2.dto.ResponseDto;
import com.sparta.schedulemanagement2.entity.Schedule;
import com.sparta.schedulemanagement2.entity.User;
import com.sparta.schedulemanagement2.entity.UserSchedule;
import com.sparta.schedulemanagement2.repository.ScheduleRepository;
import com.sparta.schedulemanagement2.repository.UserRepository;
import com.sparta.schedulemanagement2.repository.UserScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserScheduleRepository userScheduleRepository;


    public ResponseDto registschedule(RequestDto requestDto) {
        User u = userRepository.findById(requestDto.getUser_id()).orElseThrow(()->new RuntimeException("해당 유저는 없습니다."));
        UserSchedule userSchedule = new UserSchedule();
        Date date = new Date();
        Schedule s = new Schedule();

        s.setUserid(u.getUser_id());
        s.setTitle(requestDto.getTitle());
        s.setContents(requestDto.getContents());
        s.setDate(date);
        s.setFixdate(date);
        s = scheduleRepository.save(s);
        userSchedule.setUser(u);
        userSchedule.setSchedule(s);

        userScheduleRepository.save(userSchedule);

        ResponseDto r = new ResponseDto(s.getUserid(),s.getTitle(),s.getContents(),s.getDate(),s.getFixdate());

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
        ResponseDto res = new ResponseDto(schedule.getUserid(),schedule.getTitle(),schedule.getContents(),schedule.getDate(),schedule.getFixdate());
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
        r.setUsername(schedule.getUserid());
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

    public void memberregist(Long schedule_id, Long owner_Id, Long member_Id) throws Exception {
        Schedule s = scheduleRepository.findById(schedule_id).orElseThrow(()->new RuntimeException("해당 일정은 없습니다."));
        User u = userRepository.findById(member_Id).orElseThrow(()-> new RuntimeException("해당 멤버 정보가 없습니다."));
        if(!Objects.equals(s.getUserid(), owner_Id)){
            throw new Exception("해당 일정의 담당자가 아닙니다.");
        }
        UserSchedule userSchedule = new UserSchedule();
        userSchedule.setSchedule(s);
        userSchedule.setUser(u);
        userScheduleRepository.save(userSchedule);
    }
}
