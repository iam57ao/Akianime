package com.iam57.akianime.controller;

import com.iam57.akianime.dto.LoginDTO;
import com.iam57.akianime.dto.RegisterDTO;
import com.iam57.akianime.service.AuthService;
import com.iam57.akianime.vo.UserVO;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author iam57
 * @since 2024/6/28 14:03
 */
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private AuthService authService;

    @PostMapping("/register")
    public UserVO register(@RequestBody @Validated RegisterDTO registerDTO) {
        return authService.register(registerDTO);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Validated LoginDTO loginDTO) {
        return authService.login(loginDTO);
    }
}
