package com.iam57.akianime.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iam57.akianime.common.enums.CodeEnum;
import com.iam57.akianime.common.result.PageResult;
import com.iam57.akianime.dto.FavoriteDTO;
import com.iam57.akianime.dto.FavoriteUpdateDTO;
import com.iam57.akianime.entity.Animation;
import com.iam57.akianime.entity.Favorite;
import com.iam57.akianime.exception.EntityAlreadyExistsException;
import com.iam57.akianime.exception.EntityNotFoundException;
import com.iam57.akianime.exception.InvalidValueException;
import com.iam57.akianime.mapper.AnimationMapper;
import com.iam57.akianime.mapper.FavoriteMapper;
import com.iam57.akianime.service.FavoriteService;
import com.iam57.akianime.vo.FavoriteVO;
import com.iam57.akianime.vo.UserFavoriteInfoVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author iam57
 * @since 2024/6/30 15:40
 */
@Service
@AllArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteMapper favoriteMapper;
    private AnimationMapper animationMapper;

    @Override
    public PageResult<UserFavoriteInfoVO> getByUserId(Integer userId, Integer pageNum, Integer pageSize) {
        PageResult<UserFavoriteInfoVO> pageResult;
        try (Page<Object> ignored = PageHelper.startPage(pageNum, pageSize)) {
            List<UserFavoriteInfoVO> userFavoriteInfoVOList = favoriteMapper.getByUserId(userId);
            PageInfo<UserFavoriteInfoVO> pageInfo = new PageInfo<>(userFavoriteInfoVOList);
            pageResult = new PageResult<>(pageInfo);
        }
        return pageResult;
    }

    @Override
    public FavoriteVO insertByUserId(Integer userId, FavoriteDTO favoriteDTO) {
        Animation animation = animationMapper.getByAnimationId(favoriteDTO.getAnimationId());
        if (animation == null) {
            throw new EntityNotFoundException(CodeEnum.ANIMATION_NOT_FOUND);
        }
        if (favoriteMapper.getByUserIdAndAnimationId(userId, favoriteDTO.getAnimationId()) != null) {
            throw new EntityAlreadyExistsException(CodeEnum.FAVORITE_ALREADY_EXISTS);
        }
        Integer episodeCount = favoriteDTO.getEpisodeCount();
        Favorite favorite = new Favorite();
        BeanUtils.copyProperties(favoriteDTO, favorite);
        if (episodeCount == null) {
            favorite.setEpisodeCount(0);
        }
        Integer totalEpisodes = animation.getTotalEpisodes();
        if (favorite.getEpisodeCount() > totalEpisodes) {
            throw new InvalidValueException(CodeEnum.EPISODE_COUNT_INVALID);
        }
        favorite.setUserId(userId);
        favoriteMapper.insert(favorite);
        FavoriteVO favoriteVO = new FavoriteVO();
        BeanUtils.copyProperties(favorite, favoriteVO);
        return favoriteVO;
    }

    @Override
    public Integer deleteByUserIdAndAnimationIds(Integer userId, List<Integer> animationIds) {
        return favoriteMapper.deleteByUserId(userId, animationIds);
    }

    @Override
    public FavoriteVO updateByUserIdAndAnimationId(Integer userId, Integer animationId, FavoriteUpdateDTO favoriteUpdateDTO) {
        if (favoriteMapper.getByUserIdAndAnimationId(userId, animationId) == null) {
            throw new EntityNotFoundException(CodeEnum.FAVORITE_NOT_FOUND);
        }
        Animation animation = animationMapper.getByAnimationId(animationId);
        Integer totalEpisodes = animation.getTotalEpisodes();
        Integer episodeCount = favoriteUpdateDTO.getEpisodeCount();
        if (episodeCount > totalEpisodes) {
            throw new InvalidValueException(CodeEnum.EPISODE_COUNT_INVALID);
        }
        Favorite favorite = new Favorite();
        BeanUtils.copyProperties(favoriteUpdateDTO, favorite);
        favorite.setUserId(userId);
        favorite.setAnimationId(animationId);
        favoriteMapper.updateByUserIdAndAnimationId(favorite);
        FavoriteVO favoriteVO = new FavoriteVO();
        BeanUtils.copyProperties(favorite, favoriteVO);
        return favoriteVO;
    }
}
