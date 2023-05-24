package com.crud.boardserver.controller;

import com.crud.boardserver.DTO.PostDTO;
import com.crud.boardserver.domain.Post;
import com.crud.boardserver.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/write")
    public String savePost(@RequestParam String title,  @RequestParam String content) throws SQLException {

        log.info("title={}, content={}", title, content);

        PostDTO postDTO = new PostDTO();
        postDTO.setTitle(title);
        postDTO.setContent(content);

        Post post = postService.savePost(postDTO);
        log.info("savedId={}, savedTitle={}, savedContent={}", post.getId(), post.getTitle(), post.getContent());

        return "ok";
    }
}