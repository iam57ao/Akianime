package com.iam57.akianime.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.iam57.akianime.entity.User;

/**
 * @author iam57
 * @since 2024/6/28 16:00
 */
public interface JwtService {
    String createJwt(User user);

    DecodedJWT verify(String token);

    String md5(String password);
}
