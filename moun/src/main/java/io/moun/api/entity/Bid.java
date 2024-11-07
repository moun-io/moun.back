package io.moun.api.entity;

import jakarta.persistence.*;
import org.hibernate.mapping.Join;

import java.util.Date;

@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(mappedBy = "bid")
//    @JoinColumn(name="member_id")
//    private Member member;
//
//    @OneToOne(mappedBy = "bid")
//    @JoinColumn(name="auction_id")
//    private Auction auction;

    private int amount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
