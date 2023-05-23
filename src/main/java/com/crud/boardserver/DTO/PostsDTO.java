package com.crud.boardserver.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostsDTO {

    //작성일, 작성자 추가해보기
    private Integer id;
    private String title;
    private String content;

}
