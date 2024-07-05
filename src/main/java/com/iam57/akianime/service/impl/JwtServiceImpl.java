package com.iam57.akianime.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.iam57.akianime.entity.User;
import com.iam57.akianime.properties.JwtProperties;
import com.iam57.akianime.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * @author iam57
 * @since 2024/6/28 16:03
 */
@Service
@AllArgsConstructor
public class JwtServiceImpl implements JwtService {
    private JwtProperties jwtProperties;

    @Override
    public String createJwt(User user) {
        Map<String, Object> claim = new HashMap<>();
        claim.put("uid", user.getUserId());
        claim.put("role", user.getRole().name());
        return JWT.create()
                .withClaim("userInfo", claim)
                .withExpiresAt(Instant.now().plusSeconds(jwtProperties.getExpirationTime()))
                .sign(Algorithm.HMAC256(jwtProperties.getSecret()));
    }

    @Override
    public DecodedJWT verify(String token) {
        return JWT.require(Algorithm.HMAC256(jwtProperties.getSecret())).build().verify(token);
    }

    @Override
    public String md5(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
