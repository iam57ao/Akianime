package com.iam57.akianime.service;

import com.iam57.akianime.dto.UserUpdateInfoDTO;
import com.iam57.akianime.vo.UserVO;

/**
 * @author iam57
 * @since 2024/6/30 14:52
 */
public interface UserService {
    UserVO getByUserId(Integer userId);

    UserVO getByUsername(String username);

    UserVO updateByUserId(Integer userId, UserUpdateInfoDTO userUpdateInfoDTO);
}
