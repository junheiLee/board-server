package com.crud.boardserver.repository;

import com.crud.boardserver.DTO.PostDTO;
import com.crud.boardserver.connection.DBConnectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Repository
public class PostRepository {

    public PostDTO save(PostDTO postDTO) throws SQLException {
        String sql = "insert into post(postId, title, content, now) values(?, ?, ?, now())";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, postDTO.getPostId());
            pstmt.setString(2, postDTO.getTitle());
            pstmt.setString(3, postDTO.getContent());
            pstmt.executeUpdate();
            return postDTO;
        } catch (SQLException e) {
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }

    public PostDTO findById(Integer postId) throws SQLException {
        String sql = "select * from post where postId = ?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, postId);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                PostDTO postDTO = new PostDTO();
                postDTO.setPostId(rs.getInt("postId"));
                postDTO.setTitle(rs.getString("title"));
                postDTO.setContent(rs.getString("content"));
                postDTO.setDate(rs.getDate("now"));

                return postDTO;
            } else {
                throw new NoSuchElementException("post not fond postId=" + postId);
            }

        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, rs);
        }
    }

    public List<PostDTO> findAll() throws SQLException {
        String sql = "select * from post";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            List<PostDTO> posts = new ArrayList<>();

            while (rs.next()) {

                PostDTO postDTO = new PostDTO();

                postDTO.setPostId(rs.getInt("postId"));
                postDTO.setTitle(rs.getString("title"));
                postDTO.setContent(rs.getString("content"));
                postDTO.setDate(rs.getDate("now"));

                posts.add(postDTO);
            }

            return posts;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, rs);
        }
    }


    private void close(Connection con, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.error("db error", e);
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                log.error("db error", e);
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                log.error("db error", e);
            }
        }
    }

    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }
}
