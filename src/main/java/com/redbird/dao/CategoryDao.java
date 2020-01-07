package com.redbird.dao;

import com.redbird.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author wzq
 * @Date 2020/1/6 19:47
 * @Version 1.0
 */
@Mapper
@Repository
public interface CategoryDao {
    public List<Map> getCategoryList();
    public int deleteById(int id);
    public int updateById(Category category);
    public int getCount();
    public int addCategory(Category category);
}
