package com.crud.boardserver.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class PostDTO {

    //작성일, 작성자 추가해보기
    private Integer postId;
    private String title;
    private String content;
    private Date date;

}
