package com.example.demo.services.dtos.responses.like;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GetByIdLikeResponse {
    private int id;
    private LocalDateTime likeDate;
    private int userId;
    private int postId;
}
