package com.iam57.akianime.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author iam57
 * @since 2024/7/2 14:30
 */
@Setter
@Getter
public class FavoriteDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 4092084649865275111L;
    @NotNull
    private Integer animationId;
    private Integer episodeCount;
}
