package com.iam57.akianime.aspect;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.iam57.akianime.annotation.Auth;
import com.iam57.akianime.context.UserContext;
import com.iam57.akianime.common.enums.CodeEnum;
import com.iam57.akianime.common.enums.RoleEnum;
import com.iam57.akianime.exception.AuthException;
import com.iam57.akianime.service.JwtService;
import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

/**
 * @author iam57
 * @since 2024/7/4 14:07
 */
@Aspect
@Component
@AllArgsConstructor
public class AuthorityAspect {
    private JwtService jwtService;

    @Before("@annotation(auth)")
    public void around(Auth auth) {
        Map<String, Object> claim = verifyLogin();
        verifyAuthority(auth, claim);
    }

    private Map<String, Object> verifyLogin() {
        DecodedJWT decodedJWT = jwtService.verify(UserContext.getToken());
        Map<String, Object> claim = decodedJWT.getClaim("userInfo").asMap();
        UserContext.setUserId((Integer) claim.get("uid"));
        return claim;
    }

    private void verifyAuthority(Auth auth, Map<String, Object> claim) {
        RoleEnum role = Enum.valueOf(RoleEnum.class, (String) claim.get("role"));
        RoleEnum[] roles = auth.role();
        if (!Arrays.asList(roles).contains(role)) {
            throw new AuthException(CodeEnum.UNAUTHORIZED_ACCESS);
        }
    }
}
