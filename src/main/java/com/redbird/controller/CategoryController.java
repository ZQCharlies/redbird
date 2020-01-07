package com.redbird.controller;

import com.redbird.common.ResultBody;
import com.redbird.common.StateCode;
import com.redbird.pojo.Category;
import com.redbird.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author wzq
 * @Date 2020/1/6 20:12
 * @Version 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Object list(){
        List<Map> categoryList = categoryService.getCategoryList();
        int cateCount = categoryService.getCount();
        if (categoryList == null){
            return ResultBody.failure(StateCode.ERROR,"未查到分类信息");
        }
        return ResultBody.success(cateCount,categoryList);
    }

    @PutMapping
    public Object update(@RequestBody Category category){
        int re = categoryService.updateById(category);
        if (re == 0){
            return ResultBody.failure(StateCode.ERROR,"更新失败");
        }
        return ResultBody.success("更新成功");
    }

    @DeleteMapping
    public Object deleteById(int id){
        int re = categoryService.deleteById(id);
        if (re == 0){
            return ResultBody.failure(StateCode.ERROR,"删除失败");
        }
        return ResultBody.success("删除成功");
    }

    @PostMapping
    public Object addCategory(@RequestBody Category category){
        int re = categoryService.addCategory(category);
        if (re == 0){
            return ResultBody.failure(StateCode.ERROR,"添加失败");
        }
        return ResultBody.success("添加成功");
    }
}
