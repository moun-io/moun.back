package io.moun.api.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date start_time;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date end_time;
    
    private boolean isCopyrightTransfer;
    private boolean isExpired;
    private int start_bid;
    private int end_bid;



}
