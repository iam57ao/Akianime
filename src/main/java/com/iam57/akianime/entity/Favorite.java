package com.iam57.akianime.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author iam57
 * @since 2024/6/30 15:30
 */
@Setter
@Getter
public class Favorite {
    private Integer favoriteId;
    private Integer userId;
    private Integer animationId;
    private Integer episodeCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}