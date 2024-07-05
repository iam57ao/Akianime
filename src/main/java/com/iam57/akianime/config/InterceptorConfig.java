package com.iam57.akianime.config;

import com.iam57.akianime.interceptor.TokenInterceptor;
import com.iam57.akianime.interceptor.UserContextInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author iam57
 * @since 2024/6/30 17:33
 */
@Configuration
@AllArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
    private TokenInterceptor tokenInterceptor;
    private UserContextInterceptor userContextInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/auth/login",
                        "/auth/register"
                );
        registry.addInterceptor(userContextInterceptor)
                .addPathPatterns("/**");
    }
}
