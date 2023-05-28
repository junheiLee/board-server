package com.crud.boardserver.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class MemberDTO {

    private String memberId;
    private String memberName;
    private String password;
    private Date registerDate;

}
