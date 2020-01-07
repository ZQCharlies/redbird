package com.redbird.service;

import com.redbird.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @Author wzq
 * @Date 2019/12/29 11:35
 * @Version 1.0
 */
public interface UserService {
    List<User> list();
    int getCount();
    int update(User user);
    String insert(User user);
    User getByUid(String uuid);
    Map getUserByName(String name);
}
