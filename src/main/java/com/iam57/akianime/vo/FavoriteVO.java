package com.iam57.akianime.vo;

import com.iam57.akianime.common.pojo.TimeBase;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author iam57
 * @since 2024/7/2 19:45
 */
@Getter
@Setter
public class FavoriteVO extends TimeBase implements Serializable {
    @Serial
    private static final long serialVersionUID = -6382804255712826803L;
    private Integer favoriteId;
    private Integer userId;
    private Integer animationId;
    private Integer episodeCount;
}
