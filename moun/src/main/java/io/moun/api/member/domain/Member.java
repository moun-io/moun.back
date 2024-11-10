package io.moun.api.member.domain;

import io.moun.api.common.domain.BaseEntity;
import io.moun.api.song.domain.Song;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY,  mappedBy = "member")
    private List<Song> songs;
}
