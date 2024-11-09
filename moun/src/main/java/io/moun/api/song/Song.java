package io.moun.api.song;

import io.moun.api.common.domain.BaseEntity;
import io.moun.api.auction.Auction;
import io.moun.api.member.domain.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Song extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private String songFile;
    @NotNull
    private String coverImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    
    @OneToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;
}
