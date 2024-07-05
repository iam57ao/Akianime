package com.iam57.akianime.service;

import com.iam57.akianime.dto.LoginDTO;
import com.iam57.akianime.dto.RegisterDTO;
import com.iam57.akianime.vo.UserVO;

/**
 * @author iam57
 * @since 2024/6/28 14:52
 */
public interface AuthService {
    UserVO register(RegisterDTO registerDTO);

    String login(LoginDTO loginDTO);
}
