package com.iam57.akianime.service.impl;

import com.iam57.akianime.dto.UserUpdateInfoDTO;
import com.iam57.akianime.entity.User;
import com.iam57.akianime.mapper.UserMapper;
import com.iam57.akianime.service.UserService;
import com.iam57.akianime.vo.UserVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author iam57
 * @since 2024/6/30 14:53
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Override
    public UserVO getByUserId(Integer userId) {
        User user = userMapper.getByUserId(userId);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

    @Override
    public UserVO getByUsername(String username) {
        User user = userMapper.getByUsername(username);
        if (user == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

    @Override
    public UserVO updateByUserId(Integer userId, UserUpdateInfoDTO userUpdateInfoDTO) {
        User user = new User();
        BeanUtils.copyProperties(userUpdateInfoDTO, user);
        user.setUserId(userId);
        userMapper.updateByUserId(user);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

}
