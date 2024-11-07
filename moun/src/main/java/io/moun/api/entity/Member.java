package io.moun.api.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;
import java.util.Set;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

//    @OneToMany(mappedBy = "member")
//    private Set<Song> songs;
    @ManyToMany
    @JoinTable(
            name = "member_position",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id") // Position 테이블의 외래키
    )
    private Set<Position> positions;


}
