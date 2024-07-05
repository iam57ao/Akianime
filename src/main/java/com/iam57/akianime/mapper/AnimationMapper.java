package com.iam57.akianime.mapper;

import com.iam57.akianime.dto.AnimationQueryDTO;
import com.iam57.akianime.entity.Animation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author iam57
 * @since 2024/6/30 14:21
 */
@Mapper
public interface AnimationMapper {
    void insert(Animation animation);

    List<Animation> query(AnimationQueryDTO animationQueryDTO);

    Animation getByAnimationId(Integer animationId);
}
