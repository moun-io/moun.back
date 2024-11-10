package io.moun.api.member.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="authorities")
public class Authority {

    @EmbeddedId
    private AuthorityPK id;
}
