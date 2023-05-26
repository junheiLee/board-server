package com.crud.boardserver.service;

import com.crud.boardserver.DTO.PostDTO;
import com.crud.boardserver.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    private Integer id = 0;

    public List<PostDTO> findAllPosts() throws SQLException{
        return postRepository.findAll();
    }

    public PostDTO savePost(PostDTO postDTO) throws SQLException {
        id++;
        postDTO.setPostId(id);

        return postRepository.save(postDTO);
    }

    public PostDTO findPost(Integer postId) throws SQLException {
        return postRepository.findById(postId);
    }

    public void modifyPost(PostDTO updatedPost, Integer postId) throws SQLException{
        PostDTO postDTO = postRepository.findById(postId);

        if (updatedPost.getTitle() != null) {
            postDTO.setTitle(updatedPost.getTitle());
        }
        if (updatedPost.getContent() != null) {
            postDTO.setContent(updatedPost.getContent());
        }

        postRepository.modify(postDTO, postId);
    }

    public void deletePost(Integer postId) throws SQLException{
        postRepository.delete(postId);
    }
}

