package com.iam57.akianime.mapper;

import com.iam57.akianime.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author iam57
 * @since 2024/6/28 14:55
 */
@Mapper
public interface UserMapper {
    void insert(User user);

    User getByUsername(String username);

    User getByUserId(Integer userId);

    void updateByUserId(User user);
}
