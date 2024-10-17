package com.seek.candidate.application.service;

import com.seek.candidate.application.dto.CandidateDto;

import java.util.List;
import java.util.Optional;

public interface CandidateServicePort {
    CandidateDto createCandidate(CandidateDto candidateDto);
    Optional<CandidateDto> getCandidate(Long id);
    List<CandidateDto> getAllCandidates();
    CandidateDto updateCandidate(Long id, CandidateDto candidateDto);
    void deleteCandidate(Long id);
}
