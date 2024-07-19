package com.example.service;


import com.example.payload.CommentDto;

public interface CommentService {

    public  CommentDto  createComment(CommentDto dto, long postId);
}
