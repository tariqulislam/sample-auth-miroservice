package com.joinworkstudio.auth.controllers;

import com.joinworkstudio.auth.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class MemberController {

    @Autowired
    private Environment env;

    @RequestMapping("/members")
    public List<Member> getMembers() {
        List<Member> lstMember = Arrays.asList(
                new Member(1, "tariqul", "islam", "tariqul.islam.rony@gmail.com", "1234", "tariqulislam"),
                new Member(2, "Mainul", "islam", "mainul@gmail.com", "1234", "mainulislam")
        );
        return lstMember;
    }
}


