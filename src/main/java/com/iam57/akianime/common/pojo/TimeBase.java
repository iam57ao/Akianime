package com.iam57.akianime.common.pojo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author iam57
 * @since 2024/7/5 18:46
 */
@Setter
@Getter
public abstract class TimeBase {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
