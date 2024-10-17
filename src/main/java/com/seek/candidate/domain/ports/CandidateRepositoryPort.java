package com.seek.candidate.domain.ports;

import com.seek.candidate.domain.data.CandidateEntity;

import java.util.List;
import java.util.Optional;

public interface CandidateRepositoryPort {
    CandidateEntity save(CandidateEntity candidate);
    Optional<CandidateEntity> findById(Long id);
    List<CandidateEntity> findAll();
    boolean existsById(Long id);
    void deleteById(Long id);
}
