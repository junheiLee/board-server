package com.crud.boardserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/posts")
public class PostsController {

    @PostMapping("/write")
    public String postsWriteProcess(@RequestParam String title,
                                    @RequestParam String content) {

        log.info("title={}, content={}", title, content);
        return "http://localhost:5500/post/read/";
    }
}