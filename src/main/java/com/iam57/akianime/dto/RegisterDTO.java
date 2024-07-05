package com.iam57.akianime.dto;

import com.iam57.akianime.annotation.validation.ValidUsername;
import com.iam57.akianime.common.enums.GenderEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author iam57
 * @since 2024/6/28 14:43
 */
@Setter
@Getter
public class RegisterDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -2699506789334547598L;
    @ValidUsername(unique = true)
    private String username;
    private String nickname;
    @NotBlank
    private String password;
    private String avatar;
    //TODO 校验
    private GenderEnum gender;
}
