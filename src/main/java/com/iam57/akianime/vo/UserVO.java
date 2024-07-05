package com.iam57.akianime.vo;

import com.iam57.akianime.common.pojo.TimeBase;
import com.iam57.akianime.common.enums.GenderEnum;
import com.iam57.akianime.common.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author iam57
 * @since 2024/6/30 17:04
 */
@Getter
@Setter
public class UserVO extends TimeBase implements Serializable {
    @Serial
    private static final long serialVersionUID = -21522879266839771L;
    private Integer userId;
    private String username;
    private String nickname;
    private String avatar;
    private GenderEnum gender;
    private RoleEnum role;
}
