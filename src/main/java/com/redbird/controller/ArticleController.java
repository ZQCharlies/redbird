package com.redbird.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.redbird.common.ResultBody;
import com.redbird.pojo.Article;
import com.redbird.service.ArticleService;
import com.redbird.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author wzq
 * @Date 2019/12/29 11:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/{uuid}")
    public Object getArticleByUuid(@PathVariable String uuid){
        if(StringUtil.isNullOrEmpty(uuid)){
            return ResultBody.failure();
        }
        Article article = articleService.getArticleByUuid(uuid);
        return ResultBody.success(article);
    }

    @GetMapping(value = "/getCount")
    public Object getCount(){
        int count = articleService.getCount();
        return ResultBody.success(count);
    }

    @GetMapping(value = "/{pageNum}/{pageSize}")
    public Object list(@PathVariable int pageNum,@PathVariable int pageSize){
        JSONObject jsonObject = new JSONObject();
        Page<Object> page = PageHelper.startPage(pageNum,pageSize,true);
        System.out.println(pageNum);
        List<Article> list = articleService.getArticleList();
        jsonObject.put("pageNum",pageNum);
        jsonObject.put("pageSize",pageSize);
        jsonObject.put("count",page.getTotal());
        jsonObject.put("list",list);
        return ResultBody.success(jsonObject);
    }

    @PutMapping
    public Object update(@RequestBody Article article){
        int res = articleService.updateArticle(article);
        return ResultBody.success();
    }

    @PostMapping
    public Object add(@RequestBody Article article){
        article.setUuid(StringUtil.getUUID());
        articleService.insertArticle(article);
        return ResultBody.success();
    }
}
