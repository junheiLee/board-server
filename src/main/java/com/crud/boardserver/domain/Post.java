package com.crud.boardserver.domain;

import lombok.Data;

@Data
public class Post {

    private Integer id;
    private String title;
    private String content;

    public Post() {

    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
