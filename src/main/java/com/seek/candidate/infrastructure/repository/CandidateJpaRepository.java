package com.seek.candidate.infrastructure.repository;

import com.seek.candidate.domain.data.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateJpaRepository extends JpaRepository<CandidateEntity, Long> {
}
