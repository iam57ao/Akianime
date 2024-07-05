package com.iam57.akianime.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author iam57
 * @since 2024/7/3 14:37
 */
@Setter
@Getter
public class FavoriteUpdateDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -6296380317777418049L;
    @NotNull
    private Integer episodeCount;
}
