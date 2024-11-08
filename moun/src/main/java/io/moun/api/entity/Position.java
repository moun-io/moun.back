package io.moun.api.entity;

import io.moun.api.domain.member.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class Position {
    @Id
    private Long id;
    private String name;
    @ManyToMany
    private Set<Member> members;
}
