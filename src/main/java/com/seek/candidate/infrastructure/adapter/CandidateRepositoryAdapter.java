package com.seek.candidate.infrastructure.adapter;

import com.seek.candidate.application.error.Errors;
import com.seek.candidate.domain.data.CandidateEntity;
import com.seek.candidate.domain.ports.CandidateRepositoryPort;
import com.seek.candidate.infrastructure.repository.CandidateJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CandidateRepositoryAdapter implements CandidateRepositoryPort {

    private final CandidateJpaRepository candidateJpaRepository;

    public CandidateRepositoryAdapter(CandidateJpaRepository candidateJpaRepository) {
        this.candidateJpaRepository = candidateJpaRepository;
    }


    @Override
    public CandidateEntity save(CandidateEntity candidate) {
        return candidateJpaRepository.save(candidate);
    }

    @Override
    public boolean existsById(Long id){
        return candidateJpaRepository.existsById(id);
    }

    @Override
    public Optional<CandidateEntity> findById(Long id) {
        return candidateJpaRepository.findById(id);
    }

    @Override
    public List<CandidateEntity> findAll() {
        return candidateJpaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        candidateJpaRepository.deleteById(id);
    }
}
