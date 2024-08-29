package com.sparta.schedulemanagement2.repository;

import com.sparta.schedulemanagement2.entity.Schedule;
import com.sparta.schedulemanagement2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<User, Long> {
}
