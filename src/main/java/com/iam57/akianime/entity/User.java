package com.iam57.akianime.entity;

import com.iam57.akianime.common.enums.GenderEnum;
import com.iam57.akianime.common.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author iam57
 * @since 2024/6/28 13:46
 */
@Setter
@Getter
public class User {
    private Integer userId;
    private String username;
    private String nickname;
    private String password;
    private String avatar;
    private GenderEnum gender;
    private RoleEnum role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
