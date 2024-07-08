package com.example.demo.services.abstracts;

import com.example.demo.services.dtos.requests.comment.AddCommentRequest;
import com.example.demo.services.dtos.requests.comment.UpdateCommentRequest;
import com.example.demo.services.dtos.responses.comment.AddCommentResponse;
import com.example.demo.services.dtos.responses.comment.GetAllCommentResponse;
import com.example.demo.services.dtos.responses.comment.GetByIdCommentResponse;
import com.example.demo.services.dtos.responses.comment.UpdateCommentResponse;

import java.util.List;

public interface CommentService {
    AddCommentResponse crateComment(AddCommentRequest request);
    UpdateCommentResponse updateComment(UpdateCommentRequest request);
    void deleteComment(int id);
    List<GetAllCommentResponse> getAllComments();
    GetByIdCommentResponse getCommentById(int id);
}
