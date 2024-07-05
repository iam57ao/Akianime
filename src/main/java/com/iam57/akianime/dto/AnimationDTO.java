package com.iam57.akianime.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author iam57
 * @since 2024/6/30 14:17
 */
@Setter
@Getter
public class AnimationDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1798444829207581567L;
    private Integer animationId;
    @NotNull
    private String title;
    private String img;
    private String description;
    private LocalDate airDate;
    private Integer airWeekday;
    private Integer totalEpisodes;
}
