package com.crud.boardserver.repository;

import com.crud.boardserver.connection.DBConnectionUtil;
import com.crud.boardserver.domain.Post;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class PostRepository {



    public Post save(Post post) throws SQLException {
        String sql = "insert into posts(id, title, content) values(?, ?, ?)";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, post.getId());
            pstmt.setString(2, post.getTitle());
            pstmt.setString(3, post.getContent());
            pstmt.executeUpdate();
            return post;
        } catch (SQLException e) {
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }

    private void close(Connection con, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {

            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }

    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }
}
