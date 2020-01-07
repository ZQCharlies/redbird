package com.redbird.dao;

import com.redbird.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author wzq
 * @Date 2019/12/29 10:13
 * @Version 1.0
 */
@Mapper
@Repository
public interface ArticleDao {
    public Article getArticleByUuid(String uuid);
    public List<Article> getArticleList();
    public int insertArticle(Article article);
    public int updateArticle(Article article);
    public int deleteArticleById(Integer articleId);
    public int getCount();
}
