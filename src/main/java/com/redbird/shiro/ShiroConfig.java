package com.redbird.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author wzq
 * @Date 2019/12/25 15:07
 * @Version 1.0
 */
@Configuration
public class ShiroConfig {
    /**
     * 第一步：创建Realm
     */
    @Bean(name="userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }
    /**
     * 第二步：创建DefaultWebSecurityManager
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    /**
     * 第三步：创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //第四步：添加Shiro内置过滤器
        /**
         * 第四步：添加Shiro内置过滤器
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *    常用的过滤器：
         *       anon: 无需认证（登录）可以访问
         *       authc: 必须认证才可以访问
         *       user: 如果使用rememberMe的功能可以直接访问
         *       perms： 该资源必须得到资源权限才可以访问
         *       role: 该资源必须得到角色权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<String,String>();
        //配置不会被拦截的链接 顺序判断
        filterMap.put("/user/login", "anon");
        filterMap.put("/article/**", "anon");
        filterMap.put("/category/**", "anon");
        filterMap.put("/**", "authc");

        //授权过滤器
        //注意：当前授权拦截后，shiro会自动跳转到未授权页面
        // filterMap.put("/add", "perms[user:add]");
        //设置未授权提示页面
        // shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //修改调整的登录页面
        // shiroFilterFactoryBean.setLoginUrl("/toLogin");
        return shiroFilterFactoryBean;
    }
}
