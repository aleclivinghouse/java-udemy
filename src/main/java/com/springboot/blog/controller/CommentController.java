package com.springboot.blog.controller;

import com.springboot.blog.payload.PostDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springboot.blog.service.PostService;
import org.springframework.http.HttpStatus;
import com.springboot.blog.payload.PostResponse;
import java.util.List;
import com.springboot.blog.service.CommentService;
import com.springboot.blog.payload.CommentDto;

@RestController
@RequestMapping("/api/")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId, @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value="postId") long postId){
        return commentService.getCommentsByPostId(postId);
    }
    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value="postId") long postId,
                                                     @PathVariable(value="id") long commentId){

        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }
}
