package com.example.demo.services.dtos.requests.like;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateLikeRequest {
    private int id;
    private LocalDateTime likeDate;
    private int userId;
    private int postId;
}
