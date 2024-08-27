package com.sparta.schedulemanagement2.repository;

import com.sparta.schedulemanagement2.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
