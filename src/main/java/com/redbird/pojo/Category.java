package com.redbird.pojo;

/**
 * @Author wzq
 * @Date 2020/1/6 19:50
 * @Version 1.0
 */
public class Category {
    private int id;
    private int pid;
    private String name;
    private String description;
    private int order;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Category(int id, int pid, String name, String description) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
