package com.iam57.akianime.vo;

import com.iam57.akianime.common.pojo.TimeBase;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author iam57
 * @since 2024/6/30 15:49
 */
@Getter
@Setter
public class UserFavoriteInfoVO extends TimeBase implements Serializable {
    @Serial
    private static final long serialVersionUID = -8481037811980410027L;
    private Integer episodeCount;
    private AnimationVO animation;
}
