package com.iam57.akianime.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author iam57
 * @since 2024/6/28 16:41
 */
@Setter
@Getter
public class LoginDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 5362028462915645493L;
    @NotNull
    private String username;
    @NotNull
    private String password;
}
