package io.moun.api.entity;

import jakarta.persistence.*;

import java.util.Date;

public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Date createdAt;

//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;

}
