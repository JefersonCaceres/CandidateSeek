package com.seek.candidate.domain.ports;

import com.seek.candidate.domain.data.StatusEntity;

import java.util.Optional;

public interface StatusRepositoryPort {
    Optional<StatusEntity> findById(Long id);
}
