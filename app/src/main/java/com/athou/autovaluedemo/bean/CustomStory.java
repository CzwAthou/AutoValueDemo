package com.athou.autovaluedemo.bean;

/**
 * Created by athou on 2017/3/20.
 */

public class CustomStory {
    int id;
    String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CustomStory{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
