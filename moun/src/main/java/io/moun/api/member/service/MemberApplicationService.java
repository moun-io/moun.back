package io.moun.api.member.service;

import io.moun.api.member.controller.dto.RegisterRequest;

public interface MemberApplicationService {
    public void registerMemberAuth(RegisterRequest registerRequest);
    public void deleteMemberAuth(String username);
}
