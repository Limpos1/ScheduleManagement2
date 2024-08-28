package com.sparta.schedulemanagement2.repository;

import com.sparta.schedulemanagement2.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllBySchedule_id(Long scheduleId);
    @Query("SELECT COUNT(c) FROM Comment c WHERE c.schedule.id = :scheduleId")
    long countByScheduleId(@Param("scheduleId") Long scheduleId);
}
