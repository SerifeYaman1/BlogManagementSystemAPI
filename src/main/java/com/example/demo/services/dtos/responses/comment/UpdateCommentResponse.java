package com.example.demo.services.dtos.responses.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter

public class UpdateCommentResponse {
    private int id;
    private String commentText;
    private LocalDateTime commentDate;
    private int userId;
    private int postId;

}
