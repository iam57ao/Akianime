package com.iam57.akianime.dto;

import com.iam57.akianime.common.pojo.QueryBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * @author iam57
 * @since 2024/7/1 19:48
 */
@Getter
@Setter
@NoArgsConstructor
public class AnimationQueryDTO extends QueryBase implements Serializable {
    @Serial
    private static final long serialVersionUID = -2786556204074711375L;
    private String title;
    private LocalDate airDateStart;
    private LocalDate airDateEnd;
}
