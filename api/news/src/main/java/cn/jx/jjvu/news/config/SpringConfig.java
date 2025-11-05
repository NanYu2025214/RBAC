package cn.jx.jjvu.news.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JdbcConfig.class,MybatisConfig.class,ServiceConfig.class})
public class SpringConfig {
}
