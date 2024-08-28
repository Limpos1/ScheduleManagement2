package com.sparta.schedulemanagement2.repository;

import com.sparta.schedulemanagement2.dto.ResponseDto;
import com.sparta.schedulemanagement2.entity.Schedule;
import com.sparta.schedulemanagement2.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("SELECT new com.sparta.schedulemanagement2.dto.ResponseDto(s.title,s.contents,"+"(SELECT COUNT(c) FROM Comment c WHERE c.schedule.id = s.id),s.date,s.fixdate,s.username)"+"FROM Schedule s")
    Page<ResponseDto> findAllSchedules(Pageable pageable);
}
