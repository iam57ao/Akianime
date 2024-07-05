package com.iam57.akianime.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iam57.akianime.dto.AnimationDTO;
import com.iam57.akianime.dto.AnimationQueryDTO;
import com.iam57.akianime.entity.Animation;
import com.iam57.akianime.mapper.AnimationMapper;
import com.iam57.akianime.common.result.PageResult;
import com.iam57.akianime.service.AnimationService;
import com.iam57.akianime.vo.AnimationVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author iam57
 * @since 2024/6/30 14:20
 */
@Service
@AllArgsConstructor
public class AnimationServiceImpl implements AnimationService {
    private AnimationMapper animationMapper;

    @Override
    public AnimationVO insert(AnimationDTO animationDTO) {
        Animation animation = new Animation();
        BeanUtils.copyProperties(animationDTO, animation);
        animationMapper.insert(animation);
        AnimationVO animationVO = new AnimationVO();
        BeanUtils.copyProperties(animation, animationVO);
        return animationVO;
    }

    @Override
    public PageResult<AnimationVO> query(AnimationQueryDTO animationQueryDTO) {
        PageResult<AnimationVO> pageResult;
        try (Page<Object> ignored = PageHelper.startPage(animationQueryDTO.getPageNum(), animationQueryDTO.getPageSize())) {
            List<Animation> animations = animationMapper.query(animationQueryDTO);
            List<AnimationVO> animationVOS = animations.stream().map(animation -> {
                AnimationVO animationVO = new AnimationVO();
                BeanUtils.copyProperties(animation, animationVO);
                return animationVO;
            }).toList();
            PageInfo<AnimationVO> pageInfo = new PageInfo<>(animationVOS);
            pageResult = new PageResult<>(pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
        }
        return pageResult;
    }

    @Override
    public AnimationVO getByAnimationId(Integer animationId) {
        Animation animation = animationMapper.getByAnimationId(animationId);
        AnimationVO animationVO = new AnimationVO();
        BeanUtils.copyProperties(animation, animationVO);
        return animationVO;
    }
}
