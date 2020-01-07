package com.redbird.shiro;

import com.redbird.dao.UserDao;
import com.redbird.pojo.User;
import com.redbird.service.impl.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Author wzq
 * @Date 2019/12/25 15:05
 * @Version 1.0
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserServiceImpl userService;
    /*
    授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权");
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加资源的授权字符串
        info.addStringPermission("user:add");
        return info;
    }

    /*
    认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        System.out.println("执行认证");

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String name = token.getUsername();
//        String password = token.getPassword().toString();
        Map user = userService.getUserByName(name);
        if(user == null){
            throw new UnknownAccountException("用户名不存在");
        }

        //AuthenticationInfo对象中存储的是主体（Subject）的身份认证信息
        //1.principal:是认证的实体信息，可以使username也可以是数据表对应的用户的实体类对象
        Object principal = user;
        //2.credenticals:是从数据库中获取的密码
        Object credenticals = user.get("pwd");
        //3.realName:是当前realName对象的name
        String realName = getName();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,credenticals,realName);
        return info;
    }
}
