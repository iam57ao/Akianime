package com.iam57.akianime.dto.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author iam57
 * @since 2024/7/5 15:34
 */
@Getter
@Setter
@NoArgsConstructor
public abstract class QueryBase {
    private Integer pageNum;
    private Integer pageSize;
}
