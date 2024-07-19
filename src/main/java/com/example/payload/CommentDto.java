package com.example.payload;


import com.example.entity.Post;
import lombok.Data;

@Data
public class CommentDto {

    private long id;
    private String email;
    private String content;
    private Post post;
}