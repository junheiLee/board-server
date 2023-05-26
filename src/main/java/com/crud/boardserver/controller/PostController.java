package com.crud.boardserver.controller;

import com.crud.boardserver.DTO.PostDTO;
import com.crud.boardserver.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDTO>> findAllPosts() throws SQLException {
        return new ResponseEntity<List<PostDTO>>(postService.findAllPosts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostDTO> savePost(@RequestParam String title, @RequestParam String content) throws SQLException {

        log.info("title={}, content={}", title, content);

        PostDTO postDTO = new PostDTO();
        postDTO.setTitle(title);
        postDTO.setContent(content);

        return new ResponseEntity<PostDTO>(postService.savePost(postDTO), HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> findPost(@PathVariable Integer postId) throws SQLException{
        return new ResponseEntity<PostDTO>(postService.findPost(postId), HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Integer postId) throws SQLException{
        postService.deletePost(postId);
    }
}