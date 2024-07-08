package com.example.demo.services.concretes;

import com.example.demo.entities.Comment;
import com.example.demo.repositories.CommentRepository;
import com.example.demo.services.abstracts.CommentService;
import com.example.demo.services.dtos.requests.comment.AddCommentRequest;
import com.example.demo.services.dtos.requests.comment.UpdateCommentRequest;
import com.example.demo.services.dtos.responses.comment.AddCommentResponse;
import com.example.demo.services.dtos.responses.comment.GetAllCommentResponse;
import com.example.demo.services.dtos.responses.comment.GetByIdCommentResponse;
import com.example.demo.services.dtos.responses.comment.UpdateCommentResponse;
import com.example.demo.services.mappers.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    @Override
    public AddCommentResponse crateComment(AddCommentRequest request) {
        Comment comment= CommentMapper.INSTANCE.addCommentRequestToComment(request);
        Comment savedComment=commentRepository.save(comment);
        return CommentMapper.INSTANCE.commentToAddCommentResponse(savedComment);
    }
    @Override
    public UpdateCommentResponse updateComment(UpdateCommentRequest request) {
        Comment comment= CommentMapper.INSTANCE.updateCommentRequestToComment(request);
        Comment updatedComment=commentRepository.save(comment);
        return CommentMapper.INSTANCE.commentToUpdateCommentResponse(updatedComment);
    }
    @Override
    public void deleteComment(int id) {
commentRepository.deleteById(id);
    }
    @Override
    public List<GetAllCommentResponse> getAllComments() {
        List<Comment> comments=commentRepository.findAll();
        return comments.stream()
                .map(CommentMapper.INSTANCE::commentToGetAllCommentResponse)
                .collect(Collectors.toList());
    }
    @Override
    public GetByIdCommentResponse getCommentById(int id) {
        Comment comment=commentRepository.findById(id).orElseThrow(()->new RuntimeException("Comment not found"));
        return CommentMapper.INSTANCE.commentToGetByIdCommentResponse(comment);
    }
}
