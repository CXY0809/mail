package com.cxy.template.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: template
 * @description: 使用 @Component 让 Spring 管理其生命周期：
 * @author: cuixy
 * @create: 2019-08-08 15:56
 **/
@Component
public class TimeInterceptor implements HandlerInterceptor {

    /**
     * 实现 HandlerInterceptor 接口
     *
     * preHandle()  方法：进入controller层之前拦截请求
     *
     * postHandle()  方法：处理请求完成后视图渲染之前的处理操作 请求之后，控制器中抛出了异常的话就不会执行。
     *
     * afterCompletion()  方法：视图渲染之后的操作，请求之后调用，不管抛不抛出异常都会被调用.参数中异常如果被异常处理器调用的话就不会传入到参数中
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("========preHandle=========");
        System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod)handler).getMethod().getName());

        request.setAttribute("startTime", System.currentTimeMillis());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {

        System.out.println("========postHandle=========");
        Long start = (Long) request.getAttribute("startTime");
        System.out.println("耗时:"+(System.currentTimeMillis() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
            throws Exception {

        System.out.println("========afterCompletion=========");
        Long start = (Long) request.getAttribute("startTime");
        System.out.println("耗时:"+(System.currentTimeMillis() - start));

        System.out.println(exception);
    }

}