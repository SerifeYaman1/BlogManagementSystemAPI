package com.example.demo.controllers;

import com.example.demo.services.abstracts.CommentService;
import com.example.demo.services.dtos.requests.comment.AddCommentRequest;
import com.example.demo.services.dtos.requests.comment.UpdateCommentRequest;
import com.example.demo.services.dtos.responses.comment.AddCommentResponse;
import com.example.demo.services.dtos.responses.comment.GetAllCommentResponse;
import com.example.demo.services.dtos.responses.comment.GetByIdCommentResponse;
import com.example.demo.services.dtos.responses.comment.UpdateCommentResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
    private CommentService commentService;
    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping("getAll")
    public List<GetAllCommentResponse> getAllComments() {
        return commentService.getAllComments();
    }
    @GetMapping("getPostById/{id}")
    public GetByIdCommentResponse getCommentsByPostId(@PathVariable int id) {
        return commentService.getCommentById(id);
    }
    @PostMapping("create")
    public AddCommentResponse createComment(@RequestBody AddCommentRequest request) {
        return commentService.crateComment(request);
    }
    @PutMapping("update")
    public UpdateCommentResponse updateComment(@RequestBody UpdateCommentRequest request) {
        return commentService.updateComment(request);
    }
    @DeleteMapping("delete/{id}")
    public void deleteComment(@PathVariable int id) {
        commentService.deleteComment(id);
    }
}
