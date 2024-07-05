package com.iam57.akianime.interceptor;

import com.iam57.akianime.context.UserContext;
import com.iam57.akianime.properties.JwtProperties;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author iam57
 * @since 2024/6/30 17:15
 */
@Component
@AllArgsConstructor
public class TokenInterceptor implements HandlerInterceptor {
    private JwtProperties jwtProperties;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        String authHeader = request.getHeader(jwtProperties.getHeader());
        String token = authHeader.replace("Bearer ", "");
        UserContext.setToken(token);
        return true;
    }
}
