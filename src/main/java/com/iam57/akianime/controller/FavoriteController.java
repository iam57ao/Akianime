package com.iam57.akianime.controller;

import com.iam57.akianime.annotation.Auth;
import com.iam57.akianime.common.result.PageResult;
import com.iam57.akianime.context.UserContext;
import com.iam57.akianime.dto.FavoriteDTO;
import com.iam57.akianime.dto.FavoriteUpdateDTO;
import com.iam57.akianime.common.enums.RoleEnum;
import com.iam57.akianime.service.FavoriteService;
import com.iam57.akianime.vo.FavoriteVO;
import com.iam57.akianime.vo.UserFavoriteInfoVO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author iam57
 * @since 2024/6/30 15:34
 */
@Validated
@RestController
@AllArgsConstructor
public class FavoriteController {
    private FavoriteService favoriteService;

    @Auth(role = {RoleEnum.ADMIN, RoleEnum.SUPER})
    @PostMapping("/users/{user_id}/favorites")
    public FavoriteVO insertByUserId(
            @PathVariable(value = "user_id") Integer userId,
            @Validated @RequestBody FavoriteDTO favoriteDTO
    ) {
        return favoriteService.insertByUserId(userId, favoriteDTO);
    }

    @GetMapping("/users/{user_id}/favorites")
    public PageResult<UserFavoriteInfoVO> getByUserId(
            @PathVariable(value = "user_id") Integer userId,
            @NotNull
            @RequestParam(value = "page_num", required = false) Integer pageNum,
            @NotNull
            @RequestParam(value = "page_size", required = false) Integer pageSize
    ) {
        return favoriteService.getByUserId(userId, pageNum, pageSize);
    }

    @Auth(role = {RoleEnum.ADMIN, RoleEnum.SUPER})
    @DeleteMapping("/users/{user_id}/favorites/{animation_ids}")
    public Integer deleteByUserIdAndAnimationIds(
            @PathVariable("user_id") Integer userId,
            @PathVariable("animation_ids") List<Integer> animationIds
    ) {
        return favoriteService.deleteByUserIdAndAnimationIds(userId, animationIds);
    }

    @Auth(role = {RoleEnum.ADMIN, RoleEnum.SUPER})
    @PutMapping("/users/{user_id}/favorites/{animation_id}")
    public FavoriteVO updateByUserIdAndAnimationId(
            @PathVariable("user_id") Integer userId,
            @PathVariable("animation_id") Integer animationId,
            @Validated @RequestBody FavoriteUpdateDTO favoriteUpdateDTO
    ) {
        return favoriteService.updateByUserIdAndAnimationId(userId, animationId, favoriteUpdateDTO);
    }

    @Auth
    @PostMapping("/users/me/favorites")
    public FavoriteVO insertForMe(
            @Validated @RequestBody FavoriteDTO favoriteDTO
    ) {
        return favoriteService.insertByUserId(UserContext.getUserId(), favoriteDTO);
    }

    @Auth
    @DeleteMapping("/users/me/favorites/{animation_ids}")
    public Integer deleteFroMeByAnimationIds(
            @PathVariable("animation_ids") List<Integer> animationIds
    ) {
        return favoriteService.deleteByUserIdAndAnimationIds(UserContext.getUserId(), animationIds);
    }

    @Auth
    @PutMapping("/users/me/favorites/{animation_id}")
    public FavoriteVO updateFroMeByAnimationId(
            @PathVariable("animation_id") Integer animationId,
            @Validated @RequestBody FavoriteUpdateDTO favoriteUpdateDTO
    ) {
        return favoriteService.updateByUserIdAndAnimationId(UserContext.getUserId(), animationId, favoriteUpdateDTO);
    }
}
