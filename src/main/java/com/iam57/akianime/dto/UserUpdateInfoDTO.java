package com.iam57.akianime.dto;

import com.iam57.akianime.common.enums.GenderEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author iam57
 * @since 2024/7/3 16:31
 */
@Setter
@Getter
public class UserUpdateInfoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -6744947876194957116L;
    @NotBlank
    private String username;
    private String nickname;
    private String avatar;
    private GenderEnum gender;
}
