package com.redbird.service;

import com.redbird.pojo.Category;

import java.util.List;
import java.util.Map;

/**
 * @Author wzq
 * @Date 2020/1/6 20:01
 * @Version 1.0
 */
public interface CategoryService {
    public List<Map> getCategoryList();
    public int deleteById(int id);
    public int updateById(Category category);
    public int getCount();
    public int addCategory(Category category);
}
