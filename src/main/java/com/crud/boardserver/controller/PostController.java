package com.crud.boardserver.controller;

import com.crud.boardserver.DTO.PostDTO;
import com.crud.boardserver.domain.Post;
import com.crud.boardserver.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public ResponseEntity<Post> savePost(@RequestParam String title, @RequestParam String content) throws SQLException {

        log.info("title={}, content={}", title, content);

        PostDTO postDTO = new PostDTO();
        postDTO.setTitle(title);
        postDTO.setContent(content);

        return new ResponseEntity<Post>(postService.savePost(postDTO), HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> readPost(@PathVariable Integer postId) throws SQLException{
        PostDTO postDTO = postService.findPost(postId);
        log.info("id ={}, title={}, content={}",postId ,postDTO.getTitle(), postDTO.getContent());
        return new ResponseEntity<PostDTO>(postDTO, HttpStatus.OK);
    }
}