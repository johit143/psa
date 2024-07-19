package com.example.service;


import com.example.entity.Comment;
import com.example.entity.Post;
import com.example.payload.CommentDto;
import com.example.repository.CommentRepository;
import com.example.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(CommentDto dto, long postId) {
        Post post = postRepository.findById(postId).get();
       Comment com = mapToEntity(dto);
       com.setPost(post);
      Comment comment = commentRepository.save(com);
        CommentDto comDto =  mapToDto(comment);
        return comDto;
    }

    private CommentDto mapToDto(Comment com){
        CommentDto dto = new CommentDto();
        dto.setId(com.getId());
        dto.setEmail(com.getEmail());
        dto.setContent(com.getContent());
        dto.setPost(com.getPost());
        return dto;
    }
    private Comment mapToEntity(CommentDto dto) {
        Comment com = new Comment();
        com.setEmail(dto.getEmail());
        com.setContent(dto.getContent());
        return com;
    }

}
