package cn.jx.jjvu.news.config;

import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.Properties;

public class MybatisConfig {
    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean getSqlSessionFactoryBean(@Autowired DataSource dataSource){   // 创建dataSource对象，并注入
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 设置别名
        sqlSessionFactoryBean.setTypeAliasesPackage("cn.jx.jjvu.news.domain");
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties =new Properties();
        properties.setProperty("reasonable","true");
        properties.setProperty("supportmethodsArguments","true");
        properties.setProperty("params","count=countSql");
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(new PageInterceptor[]{pageInterceptor});
        // 注入数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }
    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //指定要扫描的Mapper接口所在的包
        mapperScannerConfigurer.setBasePackage("cn.jx.jjvu.news.dao");
        return mapperScannerConfigurer;
    }
}
