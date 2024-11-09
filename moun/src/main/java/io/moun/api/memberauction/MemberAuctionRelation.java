package io.moun.api.memberauction;

import io.moun.api.common.domain.BaseEntity;
import io.moun.api.auction.Auction;
import io.moun.api.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member_auction_relation", 
        uniqueConstraints = {@UniqueConstraint(
                name = "UniqueMemberAndAuction",
                columnNames = {
                        "member_id", "auction_id"
                }
        )}
)
public class MemberAuctionRelation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="auction_id")
    private Auction auction;

    private LocalDateTime bidDate;
    private int amount;
}
