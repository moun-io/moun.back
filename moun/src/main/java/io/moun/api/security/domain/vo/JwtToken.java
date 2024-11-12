package io.moun.api.security.domain.vo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@Setter
public final class JwtToken {
    private String value;
}
