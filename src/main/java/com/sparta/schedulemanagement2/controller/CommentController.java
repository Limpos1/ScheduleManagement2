package com.sparta.schedulemanagement2.controller;

import com.sparta.schedulemanagement2.dto.CommentRequestDto;
import com.sparta.schedulemanagement2.dto.CommentResponseDto;
import com.sparta.schedulemanagement2.dto.ResponseDto;
import com.sparta.schedulemanagement2.entity.Schedule;
import com.sparta.schedulemanagement2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/resist")
    public String resist(CommentRequestDto req) {
        return commentService.resist(req);
    }

    @GetMapping("/oneget")
    public CommentResponseDto getcomment(CommentRequestDto req){
        return commentService.getcomment(req);
    }

    @GetMapping("/allget")
    public List<CommentResponseDto> getAllcomment(CommentRequestDto req){
        return commentService.getAllcomment(req);
    }

    @PutMapping("/modify")
    public String modifycomment(CommentRequestDto req){
        return commentService.modifycomment(req);
    }

    @DeleteMapping("/delete")
    public String deletecomment(CommentRequestDto req){
        return commentService.deletecomment(req);
    }


}
