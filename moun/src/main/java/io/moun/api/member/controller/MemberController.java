package io.moun.api.member.controller;

import io.moun.api.member.domain.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @GetMapping
    public ResponseEntity<String> getMembers(){
        return ResponseEntity.ok("Members");
    }

}
