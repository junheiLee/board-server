package com.crud.boardserver.service;

import com.crud.boardserver.DTO.MemberDTO;
import com.crud.boardserver.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public void register(MemberDTO memberDTO) throws SQLException {

        memberRepository.save(memberDTO);

    }
}
