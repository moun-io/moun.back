package io.moun.api.common.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MounFileRepository extends JpaRepository<MounFile, Long> {
}
