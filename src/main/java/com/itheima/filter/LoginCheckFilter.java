package com.itheima.filter;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取请求url
        String url = request.getRequestURL().toString();
        log.info("请求的url：{}", url);

        //判断url是否含login
        if(url.contains("login")) {
            log.info("登录操作，放行...");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //获取JWT令牌
        String jwt = request.getHeader("token");
        if(!StringUtils.hasLength(jwt)) {
            log.info("请求头token为空，返回未登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString((error));
            response.getWriter().write(notLogin);
            return;
        }

        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString((error));
            response.getWriter().write(notLogin);
            return;
        }

        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
