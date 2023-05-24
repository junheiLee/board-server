package com.crud.boardserver.service;

import com.crud.boardserver.DTO.PostDTO;
import com.crud.boardserver.domain.Post;
import com.crud.boardserver.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    private Integer id = 0;

    public Post savePost(PostDTO postDTO) throws SQLException {

        id++;

        Post post = new Post();
        post.setPostId(id);
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());

        return postRepository.save(post);
    }

    public PostDTO findPost(Integer postId) throws SQLException {

        Post post = postRepository.findById(postId);

        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(postId);
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());

        return postDTO;
    }
}

