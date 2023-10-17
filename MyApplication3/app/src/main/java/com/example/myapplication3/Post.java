package com.example.myapplication3;

import java.util.List;

public final class Post {
    private String title;
    private String body;
    private Integer userId;
    private Integer id;

    private List<String> sp2;

    public Post(String title, String body, Integer userId, Integer id, List<String> sp2) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
        this.sp2 = sp2;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getSp2() {
        return sp2;
    }

    public void setSp2(List<String> sp2) {
        this.sp2 = sp2;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
