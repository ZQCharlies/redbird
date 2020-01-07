package com.redbird.pojo;

import java.util.Date;

/**
 * @Author wzq
 * @Date 2019/12/29 10:06
 * @Version 1.0
 */
public class Article {
    private String uuid;
    private String title;
    private String abscontent;
    private String author;
    private String tage;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private int viewcount;
    private int commcount;
    private int likecount;
    private Date createtime;
    private Date updatetime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbscontent() {
        return abscontent;
    }

    public void setAbscontent(String abscontent) {
        this.abscontent = abscontent;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTage() {
        return tage;
    }

    public void setTage(String tage) {
        this.tage = tage;
    }

    public int getViewcount() {
        return viewcount;
    }

    public void setViewcount(int viewcount) {
        this.viewcount = viewcount;
    }

    public int getCommcount() {
        return commcount;
    }

    public void setCommcount(int commcount) {
        this.commcount = commcount;
    }

    public int getLikecount() {
        return likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
