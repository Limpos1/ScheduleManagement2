package com.sparta.schedulemanagement2.repository;

import com.sparta.schedulemanagement2.entity.Schedule;
import com.sparta.schedulemanagement2.entity.User;
import com.sparta.schedulemanagement2.entity.UserSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserScheduleRepository extends JpaRepository<UserSchedule, Long> {
    List<User> findAllBySchedule(Schedule schedule);
}
