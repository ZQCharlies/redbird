package com.redbird.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 已停用
 */
public class MyInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userName = request.getParameter("username");
        String userPwsd = request.getParameter("userpwsd");
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String user = (String) valueOperations.get("");
        if (user == null){
            //登录
            //如果成功
            //保存到redis
            String token = UUID.randomUUID().toString()+userName;
            valueOperations.set(token,"user对象",60, TimeUnit.MINUTES);
            //如果不成功
            return false;
        }else {
            //转换成User对象
        }
        System.out.println("在调用处理器之前运行,false代表不放行true代表放行");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("在处理器调用之后运行，视图解析器之前运行");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("在处理器调用之后运行，视图解析器之后运行");
    }
}
