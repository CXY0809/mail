package com.cxy.template.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @program: template
 * @description: mybatis
 * @author: cuixy
 * @create: 2019-08-09 14:37
 **/
@Configuration
public class MyBatisConfiguration {

    @Bean
    @ConditionalOnMissingBean // 当容器里没有指定的 Bean 的情况下创建该对象
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {


        /**
         * Springboot整合Elasticsearch 在项目启动前设置一下的属性，防止报错
         * 解决netty冲突后初始化client时还会抛出异常
         * java.lang.IllegalStateException: availableProcessors is already set to [4], rejecting [4]
         */
        System.setProperty("es.set.netty.runtime.available.processors", "false");

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);

        // 设置mybatis的主配置文件
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));

        // 设置mapper映射文件
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] mapperXml;
        try {
            mapperXml = resolver.getResources("classpath:mybatis/mapper/*.xml");
            sqlSessionFactoryBean.setMapperLocations(mapperXml);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 设置别名包
        sqlSessionFactoryBean.setTypeAliasesPackage("com.cxy.template.entity");

        return sqlSessionFactoryBean;
    }

    @Bean
    @ConditionalOnBean(SqlSessionFactoryBean.class) // 当 SqlSessionFactoryBean 实例存在时创建对象
    public MapperScannerConfigurer mapperScannerConfigurer() {

        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.cxy.template.mysql");
        return mapperScannerConfigurer;
    }
}