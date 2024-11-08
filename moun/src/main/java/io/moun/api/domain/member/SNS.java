package io.moun.api.domain.member;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SNS {
    private String instagramSNS;
    private String soundCloudSNS;

    @Builder
    public SNS(String instagramSNS, String soundCloudSNS) {
        this.instagramSNS = instagramSNS;
        this.soundCloudSNS = soundCloudSNS;
    }
}
