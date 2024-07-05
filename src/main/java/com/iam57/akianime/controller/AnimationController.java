package com.iam57.akianime.controller;

import com.iam57.akianime.annotation.Auth;
import com.iam57.akianime.dto.AnimationDTO;
import com.iam57.akianime.dto.AnimationQueryDTO;
import com.iam57.akianime.common.enums.RoleEnum;
import com.iam57.akianime.common.result.PageResult;
import com.iam57.akianime.service.AnimationService;
import com.iam57.akianime.vo.AnimationVO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * @author iam57
 * @since 2024/6/30 14:14
 */
@Validated
@RestController
@RequestMapping("/animations")
@AllArgsConstructor
public class AnimationController {
    private AnimationService animationService;

    @Auth(role = {RoleEnum.ADMIN, RoleEnum.SUPER})
    @PostMapping
    public AnimationVO insert(@RequestBody @Validated AnimationDTO animationDTO) {
        return animationService.insert(animationDTO);
    }

    @GetMapping
    public PageResult<AnimationVO> query(
            @RequestParam(required = false) String title,
            @RequestParam(value = "air_date_start", required = false) LocalDate airDateStart,
            @RequestParam(value = "air_date_end", required = false) LocalDate airDateEnd,
            @NotNull
            @RequestParam(value = "page_num", required = false) Integer pageNum,
            @NotNull
            @RequestParam(value = "page_size", required = false) Integer pageSize
    ) {
        AnimationQueryDTO animationQueryDTO = new AnimationQueryDTO();
        animationQueryDTO.setTitle(title);
        animationQueryDTO.setAirDateStart(airDateStart);
        animationQueryDTO.setAirDateEnd(airDateEnd);
        animationQueryDTO.setPageNum(pageNum);
        animationQueryDTO.setPageSize(pageSize);
        return animationService.query(animationQueryDTO);
    }

    @GetMapping("/{animation_id}")
    public AnimationVO getByAnimationId(@PathVariable(value = "animation_id") Integer animationId) {
        return animationService.getByAnimationId(animationId);
    }
}
