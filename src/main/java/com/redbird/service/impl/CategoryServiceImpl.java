package com.redbird.service.impl;

import com.redbird.dao.CategoryDao;
import com.redbird.pojo.Category;
import com.redbird.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author wzq
 * @Date 2020/1/6 20:02
 * @Version 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Map> getCategoryList() {
        return categoryDao.getCategoryList();
    }

    @Override
    public int deleteById(int id) {
        int res = categoryDao.deleteById(id);
        if (res == 0) return 0;
        return 1;
    }

    @Override
    public int getCount() {

        return categoryDao.getCount();
    }

    @Override
    public int addCategory(Category category) {
        int re = categoryDao.addCategory(category);
        if (re == 0) return 0;
        return 1;
    }

    @Override
    public int updateById(Category category) {
        int re = categoryDao.updateById(category);
        if (re == 0 ) return 0;
        return 1;
    }
}
