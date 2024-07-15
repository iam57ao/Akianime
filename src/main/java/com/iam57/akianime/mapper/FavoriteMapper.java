package com.iam57.akianime.mapper;

import com.iam57.akianime.entity.Favorite;
import com.iam57.akianime.vo.UserFavoriteInfoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author iam57
 * @since 2024/6/30 15:40
 */
@Mapper
public interface FavoriteMapper {
    List<UserFavoriteInfoVO> getByUserId(Integer userId);

    void insert(Favorite favorite);

    Integer deleteByUserId(Integer userId, List<Integer> animationIds);

    void updateByUserIdAndAnimationId(Favorite favorite);

    Favorite getByFavoriteId(Integer favoriteId);

    Favorite getByUserIdAndAnimationId(Integer userId, Integer animationId);
}
