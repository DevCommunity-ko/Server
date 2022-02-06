package com.devko.magnet.util.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // 일단 모든 origin을 허용 -> 운영 시 변경하는 것으로!
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("PUT", "PATCH", "OPTIONS", "DELETE")
                .maxAge(3600);

    }
}
