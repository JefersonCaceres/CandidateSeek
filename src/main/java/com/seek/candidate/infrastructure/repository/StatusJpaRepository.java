package com.seek.candidate.infrastructure.repository;

import com.seek.candidate.domain.data.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusJpaRepository extends JpaRepository<StatusEntity, Long> {
}
