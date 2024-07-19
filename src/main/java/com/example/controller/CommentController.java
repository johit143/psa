package com.example.controller;

import com.example.payload.CommentDto;
import com.example.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ap1/v1/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping
  public ResponseEntity<CommentDto> createComment(
          @RequestBody CommentDto dto,
          @RequestParam long postId
          ){
        CommentDto commentDto = commentService.createComment(dto, postId);
        return new ResponseEntity<>(commentDto , HttpStatus.CREATED);
    }
}
