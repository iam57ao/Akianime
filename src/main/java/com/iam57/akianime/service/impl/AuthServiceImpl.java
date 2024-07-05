package com.iam57.akianime.service.impl;

import com.iam57.akianime.dto.LoginDTO;
import com.iam57.akianime.dto.RegisterDTO;
import com.iam57.akianime.entity.User;
import com.iam57.akianime.common.enums.CodeEnum;
import com.iam57.akianime.common.enums.RoleEnum;
import com.iam57.akianime.exception.AuthException;
import com.iam57.akianime.mapper.UserMapper;
import com.iam57.akianime.service.AuthService;
import com.iam57.akianime.service.JwtService;
import com.iam57.akianime.vo.UserVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author iam57
 * @since 2024/6/28 14:52
 */
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private JwtService jwtService;
    private UserMapper userMapper;

    @Override
    public UserVO register(RegisterDTO registerDTO) {
        String rawPassword = registerDTO.getPassword();
        registerDTO.setPassword(jwtService.md5(rawPassword));
        User user = new User();
        BeanUtils.copyProperties(registerDTO, user);
        user.setRole(RoleEnum.USER);
        userMapper.insert(user);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

    @Override
    public String login(LoginDTO loginDTO) {
        User user = userMapper.getByUsername(loginDTO.getUsername());
        if (user == null) {
            throw new AuthException(CodeEnum.USER_NOT_FOUND);
        }
        String password = jwtService.md5(loginDTO.getPassword());
        if (!password.equals(user.getPassword())) {
            throw new AuthException(CodeEnum.PASSWORD_INCORRECT);
        }
        return jwtService.createJwt(user);
    }
}
