package com.example.demo.services.dtos.requests.like;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class AddLikeRequest {
    private LocalDateTime likeDate;
    private int userId;
    private int postId;
}
