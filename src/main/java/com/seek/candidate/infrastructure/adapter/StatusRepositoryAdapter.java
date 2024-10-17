package com.seek.candidate.infrastructure.adapter;

import com.seek.candidate.domain.data.StatusEntity;
import com.seek.candidate.domain.ports.StatusRepositoryPort;
import com.seek.candidate.infrastructure.repository.StatusJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class StatusRepositoryAdapter implements StatusRepositoryPort {

    private final StatusJpaRepository statusJpaRepository;

    public StatusRepositoryAdapter(StatusJpaRepository statusJpaRepository) {
        this.statusJpaRepository = statusJpaRepository;
    }

    @Override
    public Optional<StatusEntity> findById(Long id) {
        return statusJpaRepository.findById(id);
    }
}
