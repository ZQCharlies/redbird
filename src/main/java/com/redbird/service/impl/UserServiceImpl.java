package com.redbird.service.impl;

import com.redbird.dao.UserDao;
import com.redbird.pojo.User;
import com.redbird.service.UserService;
import com.redbird.util.PwdUtil;
import com.redbird.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    public List<User> list(){

        return userDao.list();
    }

    public User getByUid(String uuid){
        User user = userDao.getByUid(uuid);
        return user;
    }

    @Override
    public Map getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    public int getCount(){
        return userDao.getCount();
    }
    public int update(User user){
        int res = userDao.update(user);
        return res;
    }
    public String insert(User user){
        String uuidStr = StringUtil.getUUID();
        user.setPwd(PwdUtil.md5(user.getPwd()));
        user.setUuid(uuidStr);
        int id = userDao.insert(user);
        if (id != 0)
           return uuidStr;
        return "";
    }
}
