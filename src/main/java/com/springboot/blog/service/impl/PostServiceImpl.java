package com.springboot.blog.service.impl;

import com.springboot.blog.service.PostService;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.entity.Post;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto){

        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post newPost = postRepository.save(post);

        PostDto postResponse = new PostDto();
        postResponse.setId(newPost.getId());
        postResponse.setTitle(newPost.getTitle());
        postResponse.setDescription(newPost.getDescription());
        postResponse.setContent(newPost.getContent());

        return postResponse;
    }

    @Override public List<PostDto> getAllPosts(){
        return null;
    }

}
