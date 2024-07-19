package com.example.service;

import com.example.entity.Post;
import com.example.payload.PostDto;
import com.example.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public PostDto createPost(PostDto dto) {
        Post post = mapToEntity(dto);
        Post posts = postRepository.save(post);
        PostDto postDto = mapToDto(posts);
        return postDto;

    }

    private PostDto mapToDto(Post posts) {
        PostDto dto = new PostDto();
        dto.setId(posts.getId());
        dto.setTitle(posts.getTitle());
        dto.setDescription(posts.getDescription());
        return dto;
    }

    private Post mapToEntity(PostDto dto) {
        Post post = new Post();
        post.setId(dto.getId());
        post.setTitle(dto.getTitle());
        post.setDescription(dto.getDescription());
        return post;
    }
}