package com.iam57.akianime.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author iam57
 * @since 2024/7/1 19:33
 */
@Getter
@Setter
public class AnimationVO implements Serializable {
    @Serial
    private static final long serialVersionUID = -4336647400386121103L;
    private Integer animationId;
    private String title;
    private String img;
    private String description;
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate airDate;
    private Integer airWeekday;
    private Integer totalEpisodes;
}
