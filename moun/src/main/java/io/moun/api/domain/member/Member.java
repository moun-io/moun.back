package io.moun.api.domain.member;

import io.moun.api.domain.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Auth auth;
    @Embedded
    private SNS sns;
    
    @NotNull
    private String nickname;
    @NotNull
    private String information;
    @NotNull
    private String profilePicture;
}
