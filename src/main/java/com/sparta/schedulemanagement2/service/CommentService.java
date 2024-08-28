package com.sparta.schedulemanagement2.service;

import com.sparta.schedulemanagement2.dto.CommentRequestDto;
import com.sparta.schedulemanagement2.dto.CommentResponseDto;
import com.sparta.schedulemanagement2.dto.ResponseDto;
import com.sparta.schedulemanagement2.entity.Comment;
import com.sparta.schedulemanagement2.entity.Schedule;
import com.sparta.schedulemanagement2.repository.CommentRepository;
import com.sparta.schedulemanagement2.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private CommentRepository commentRepository;

    public String resist(CommentRequestDto req) {
        Schedule schedule = scheduleRepository.findById(req.getSchedule_id()).orElseThrow(()->new RuntimeException("해당 일정은 없습니다."));

        Comment comment = new Comment();

        comment.setComment(req.getComment());
        comment.setUsername(req.getUsername());
        comment.setDate(new Date());
        comment.setFix_date(new Date());
        comment.setSchedule(schedule);
        commentRepository.save(comment);

        return "댓글 등록 성공";

    }

    public CommentResponseDto getcomment(CommentRequestDto req) {
        Comment c = commentRepository.findById(req.getId()).orElseThrow(()->new RuntimeException("해당 댓글을 찾을 수 없습니다."));

        CommentResponseDto res = new CommentResponseDto(c.getId(),c.getComment(),c.getUsername(),c.getDate(),c.getFix_date(),c.getSchedule().getId());

        return res;
    }


    public List<CommentResponseDto> getAllcomment(CommentRequestDto req) {
        Schedule s = scheduleRepository.findById(req.getSchedule_id()).orElseThrow(()-> new RuntimeException("해당 일정은 없습니다."));

        List<Comment> comments = s.getComments();

        return comments.stream().
                map(comment -> new CommentResponseDto(comment.getId(), comment.getComment(), comment.getUsername(),comment.getDate(),comment.getFix_date(), comment.getSchedule().getId()))
                .collect(Collectors.toList());
    }

    public String modifycomment(CommentRequestDto req) {
        Comment c = commentRepository.findById(req.getId()).orElseThrow(()->new RuntimeException("해당 댓글을 찾을 수 없습니다."));
        c.setComment(req.getComment());
        c.setFix_date(new Date());
        commentRepository.save(c);

        return "수정 성공";
    }

    public String deletecomment(CommentRequestDto req) {
        Comment c = commentRepository.findById(req.getId()).orElseThrow(()->new RuntimeException("해당 댓글을 찾을 수 없습니다."));
        commentRepository.deleteById(req.getId());
        return "삭제 성공";
    }
}
