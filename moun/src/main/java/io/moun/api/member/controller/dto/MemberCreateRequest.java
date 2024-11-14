package io.moun.api.member.controller.dto;


import io.moun.api.member.domain.SNS;
import io.moun.api.security.domain.Auth;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MemberCreateRequest  {


    private String username;

}
