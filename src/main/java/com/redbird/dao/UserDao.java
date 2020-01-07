package com.redbird.dao;

import com.redbird.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface UserDao {
    List<User> list();
    int getCount();
    int update(User user);
    int insert(User user);
    User getByUid(String uuid);
    Map getUserByName(String name);
}
