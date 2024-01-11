package com.myblog.myblog11.service.impl;

import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.payload.PostDto;
import com.myblog.myblog11.repository.PostRepository;
import com.myblog.myblog11.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {


    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {

        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto){

        Post post = new Post();

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post savedPost = postRepository.save(post);

        PostDto dto = new PostDto();
        dto.setTitle(savedPost.getTitle());
        dto.setContent(savedPost.getContent());
        dto.setDescription(savedPost.getDescription());

        return dto;
    }
}
