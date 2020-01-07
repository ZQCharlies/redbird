package com.redbird.service;

import com.redbird.pojo.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author wzq
 * @Date 2019/12/29 11:12
 * @Version 1.0
 */
public interface ArticleService {
    public Article getArticleByUuid(String uuid);
    public List<Article> getArticleList();
    public int insertArticle(Article article);
    public int updateArticle(Article article);
    public int deleteArticleById(Integer articleId);
    public int getCount();
}
