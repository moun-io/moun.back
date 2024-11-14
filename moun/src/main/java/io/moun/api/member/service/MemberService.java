package io.moun.api.member.service;

import io.moun.api.member.controller.dto.MemberCreateRequest;
import io.moun.api.member.domain.Member;

import java.security.Principal;

public interface MemberService {
    public Member findById(Long id);
    public void save(Principal principal);

}
