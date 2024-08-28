package com.sparta.schedulemanagement2.repository;

import com.sparta.schedulemanagement2.entity.UserSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserScheduleRepository extends JpaRepository<UserSchedule, Long> {

}
