package com.crud.boardserver.repository;

import com.crud.boardserver.DTO.MemberDTO;
import com.crud.boardserver.connection.DBConnectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Slf4j
@Repository
public class MemberRepository {

    public void save(MemberDTO memberDTO) throws SQLException {
        String sql = "insert into member(memberId, memberName, password, registerDate) values(?, ?, ?, now())";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberDTO.getMemberId());
            pstmt.setString(2, memberDTO.getMemberId());
            pstmt.setString(3, memberDTO.getPassword());
            pstmt.executeUpdate();
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
