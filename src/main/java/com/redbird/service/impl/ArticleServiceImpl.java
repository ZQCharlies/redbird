package com.redbird.service.impl;

import com.redbird.dao.ArticleDao;
import com.redbird.pojo.Article;
import com.redbird.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.Action;
import java.util.List;

/**
 * @Author wzq
 * @Date 2019/12/29 11:14
 * @Version 1.0
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Override
    public Article getArticleByUuid(String uuid) {
        return articleDao.getArticleByUuid(uuid);
    }

    @Override
    public List<Article> getArticleList() {
        return articleDao.getArticleList();
    }

    @Override
    public int insertArticle(Article article) {
        return articleDao.insertArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleDao.updateArticle(article);
    }

    @Override
    public int deleteArticleById(Integer articleId) {
        return articleDao.deleteArticleById(articleId);
    }

    @Override
    public int getCount() {
        return articleDao.getCount();
    }
}
