package com.example.demo2.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "newTeacherFilter", urlPatterns = "/*")
public class NewTeacherFilter implements Filter {
    @Override
    public void init(FilterConfig var1) throws ServletException {
        System.out.println("---------->>> init");
    }

    @Override
    public void doFilter(ServletRequest var1, ServletResponse var2, FilterChain var3) throws IOException, ServletException {
        System.out.println("---------->>> doFilter");
        var3.doFilter(var1, var2);
    }

    @Override
    public void destroy() {
        System.out.println("--------->>> destroy");
    }
}
