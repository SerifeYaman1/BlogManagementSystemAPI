package com.example.demo.services.dtos.responses.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AddCommentResponse {
    private int id;
    private String commentText;
    private LocalDateTime commentDate;
    private int userId;
    private int postId;
}
