package com.iam57.akianime.service.impl;

import com.iam57.akianime.dto.FavoriteDTO;
import com.iam57.akianime.dto.FavoriteUpdateDTO;
import com.iam57.akianime.entity.Favorite;
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

    @Override
    public List<UserFavoriteInfoVO> getByUserId(Integer userId) {
        return favoriteMapper.getByUserId(userId);
    }

    @Override
    public FavoriteVO insertByUserId(Integer userId, FavoriteDTO favoriteDTO) {
        Favorite favorite = new Favorite();
        BeanUtils.copyProperties(favoriteDTO, favorite);
        if (favorite.getEpisodeCount() == null) {
            favorite.setEpisodeCount(0);
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
