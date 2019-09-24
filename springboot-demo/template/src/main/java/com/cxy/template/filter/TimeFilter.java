package com.cxy.template.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: template
 * @description: 自定义过滤器/第三方过滤器 直接引入 import javax.servlet.*;
 * @author: cuixy
 * @create: 2019-08-08 15:31
 **/
public class TimeFilter  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=======初始化过滤器=========");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        long start = System.currentTimeMillis();

        filterChain.doFilter(request, response);

        System.out.println("filter 耗时：" + (System.currentTimeMillis() - start));

    }

    @Override
    public void destroy() {
        System.out.println("=======销毁过滤器=========");
    }


}