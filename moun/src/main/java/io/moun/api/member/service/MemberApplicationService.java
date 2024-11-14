package io.moun.api.member.service;

import io.moun.api.member.controller.dto.RegisterRequest;

public interface MemberApplicationService {
    public boolean registerMemberAuth(RegisterRequest registerRequest);
    public void deleteMemberAuth(String username);
}
