package com.iam57.akianime.service;

import com.iam57.akianime.dto.AnimationDTO;
import com.iam57.akianime.dto.AnimationQueryDTO;
import com.iam57.akianime.common.result.PageResult;
import com.iam57.akianime.vo.AnimationVO;

/**
 * @author iam57
 * @since 2024/6/30 14:16
 */
public interface AnimationService {
    AnimationVO insert(AnimationDTO animationDTO);

    PageResult<AnimationVO> query(AnimationQueryDTO animationQueryDTO);

    AnimationVO getByAnimationId(Integer animationId);
}
