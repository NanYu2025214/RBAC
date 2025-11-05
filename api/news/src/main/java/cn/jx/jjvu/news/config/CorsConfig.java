package cn.jx.jjvu.news.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/logcontroller/**") // 允许跨域访问的路径
                .allowedOrigins("http://localhost:81") // 允许的源
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的方法
                .allowedHeaders("*") // 允许的头信息
                .exposedHeaders("*") // 暴露给前端的头部
                .allowCredentials(true); // 是否允许携带 cookie
    }
}
