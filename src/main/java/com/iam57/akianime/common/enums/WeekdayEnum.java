package com.iam57.akianime.common.enums;

import lombok.AllArgsConstructor;

/**
 * @author iam57
 * @since 2024/6/30 14:10
 */
@AllArgsConstructor
public enum WeekdayEnum {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private final Integer weekday;
}
