package com.iam57.akianime.controller;

import com.iam57.akianime.annotation.Auth;
import com.iam57.akianime.context.UserContext;
import com.iam57.akianime.dto.UserUpdateInfoDTO;
import com.iam57.akianime.service.UserService;
import com.iam57.akianime.vo.UserVO;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author iam57
 * @since 2024/6/30 17:03
 */
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/{user_id}")
    public UserVO getByUserId(@PathVariable(value = "user_id") Integer userId) {
        return userService.getByUserId(userId);
    }

    @Auth
    @GetMapping("/me")
    public UserVO getForMe() {
        return userService.getByUserId(UserContext.getUserId());
    }

    @Auth
    @PatchMapping("/me/info")
    public UserVO updateForMe(@Validated @RequestBody UserUpdateInfoDTO userUpdateInfoDTO) {
        return userService.updateByUserId(UserContext.getUserId(), userUpdateInfoDTO);
    }
}
