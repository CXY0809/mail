package com.cxy.template.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.cxy.template.Interceptor.TimeInterceptor;
import com.cxy.template.filter.TimeFilter;
import com.cxy.template.listener.ListenerTest;
import com.cxy.template.servlet.ServletTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: template
 * @description: web 配置管理类
 * @author: cuixy
 * @create: 2019-08-08 15:15
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {


    //编写拦截器后，我们还需要将其注册到拦截器链中，如下配置：
    @Autowired
    private TimeInterceptor timeInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }


    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;

        return new HttpMessageConverters(converter);

    }

    //将 Servelt 注册成 Bean。
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new ServletTest(),"/servletTest");
    }


    /**
     * 要是该过滤器生效，有两种方式：
     *
     * 使用 @Component 注解
     *
     * 添加到过滤器链中，此方式适用于使用第三方的过滤器。将过滤器写到 WebConfig 类中，如下：
     * @return
     */
    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);

        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);

        return registrationBean;
    }


    /**
     * 注册监听器
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean<ListenerTest> servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<ListenerTest>(new ListenerTest());
    }

    /**
     * 跨域方式一
     * @return
     */
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/fastjson/**")
//                        .allowedOrigins("http://localhost:8080");// 允许 8080 端口访问
//            }
//        };
//    }


    /**
     * 跨域方式二  extends WebMvcConfigurerAdapter
     * @return
     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/fastjson/**")
//                .allowedOrigins("http://localhost:8080");// 允许 8080 端口访问
//    }

    /**
     * 跨域方式三 接口上加注解  @CrossOrigin(origins="http://localhost:8080")
     * @return
     */


}