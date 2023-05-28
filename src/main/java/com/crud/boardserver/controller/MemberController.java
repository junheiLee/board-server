package com.crud.boardserver.controller;

import com.crud.boardserver.DTO.MemberDTO;
import com.crud.boardserver.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping
    public void registerUser(@RequestParam String memberId,
                             @RequestParam String memberName,
                             @RequestParam String password) throws SQLException{
        log.info("userId={}, userName={}, password={}", memberId, memberName, password);

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberId(memberId);
        memberDTO.setMemberName(memberName);
        memberDTO.setPassword(password);

        memberService.register(memberDTO);
    }

}
