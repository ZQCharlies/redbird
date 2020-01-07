package com.redbird.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.redbird.common.ResultBody;
import com.redbird.common.StateCode;
import com.redbird.pojo.User;
import com.redbird.service.impl.UserServiceImpl;
import com.redbird.util.RedisUtis;
import com.redbird.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/{pageNum}/{pageSize}",method = RequestMethod.GET)
    public Object getUserList(@PathVariable int pageNum,@PathVariable int pageSize){
        JSONObject jsonObject = new JSONObject();
        if (pageNum <0 || pageSize <=0){
            pageNum =1;
            pageSize = 10;
        }
        Page<User> page = PageHelper.startPage(pageNum,pageNum,true);
        List<User> list = userService.list();
        jsonObject.put("nowpage",pageNum);
        jsonObject.put("pageSize",page.getTotal());
        jsonObject.put("list",list);
        return ResultBody.success(jsonObject);
    }

    @RequestMapping(value = "/{uuid}",method = RequestMethod.GET)
    public Object getUserByUid(@PathVariable String uuid){
        User user = userService.getByUid(uuid);
        return ResultBody.success(user);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public Object update(@RequestBody User user){
        userService.update(user);
        return ResultBody.success();
    }
    @RequestMapping(method = RequestMethod.POST)
    public Object add(@RequestBody User user){
        System.out.println(user.getName());
        String uuid = userService.insert(user);
        if (!StringUtil.isNullOrEmpty(uuid)){
            return ResultBody.success(uuid);
        }
        return ResultBody.failure();
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(@RequestBody String data){
        JSONObject jo = JSONObject.parseObject(data).getJSONObject("data");
        String username = jo.getString("uname");
        String password = jo.getString("pass");
        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        System.out.println(token.toString());
        //3.执行登录方法
        try {
            subject.login(token);
            JSONObject res = new JSONObject();
            String utoken = StringUtil.getUUID();
            redisTemplate.opsForValue().set(username,utoken);
            res.put("token",utoken);

            return new ResultBody(true,StateCode.OK,"登录成功！",res);
        } catch (UnknownAccountException e) {
            return ResultBody.failure(StateCode.LOGINERROR,"用户名不存在");
        }catch (IncorrectCredentialsException e) {
            return ResultBody.failure(StateCode.LOGINERROR,"密码错误");
        }catch (AuthenticationException e){
            return ResultBody.failure(StateCode.LOGINERROR,"用户/密码错误");
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public Object logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()){
            subject.logout();
        }
        return ResultBody.success("退出成功");
    }
}
