package com.iam57.akianime.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author iam57
 * @since 2024/6/30 14:07
 */
@Setter
@Getter
public class Animation {
    private Integer animationId;
    private String title;
    private String img;
    private String description;
    private LocalDate airDate;
    private Integer airWeekday;
    private Integer totalEpisodes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
