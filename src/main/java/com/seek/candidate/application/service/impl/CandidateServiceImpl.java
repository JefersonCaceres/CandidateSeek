package com.seek.candidate.application.service.impl;

import com.seek.candidate.application.dto.CandidateDto;
import com.seek.candidate.application.error.Errors;
import com.seek.candidate.application.mapper.CandidateMapper;
import com.seek.candidate.application.service.CandidateServicePort;
import com.seek.candidate.domain.data.CandidateEntity;
import com.seek.candidate.domain.data.StatusEntity;
import com.seek.candidate.domain.ports.CandidateRepositoryPort;
import com.seek.candidate.domain.ports.StatusRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateServicePort {
    private final CandidateRepositoryPort candidateRepository;
    private final StatusRepositoryPort statusRepository;
    private final CandidateMapper candidateMapper;

    public CandidateServiceImpl(CandidateRepositoryPort candidateRepository, StatusRepositoryPort statusRepository, CandidateMapper candidateMapper) {
        this.candidateRepository = candidateRepository;
        this.statusRepository = statusRepository;
        this.candidateMapper = candidateMapper;
    }

    @Override
    public CandidateDto createCandidate(CandidateDto candidateDto) {
        isValidateCandidate(candidateDto);
        if(candidateDto.getId()!=null) {
            if (candidateRepository.existsById(candidateDto.getId()))
                throw new Errors("OrderItem already exists with id: " + candidateDto.getId());
        }
        candidateDto.setCreatedAt(LocalDate.now());
        CandidateEntity candidateEntity = candidateMapper.toEntity(candidateDto);
        CandidateEntity savedEntity = candidateRepository.save(candidateEntity);
        return candidateMapper.toDto(savedEntity);
    }

    @Override
    public  Optional<CandidateDto> getCandidate(Long id) {
        Optional<CandidateEntity> candidateEntity = candidateRepository.findById(id);
        if (!candidateEntity.isPresent())
            throw new Errors("Not exist candidate registered by " + id);
        return candidateMapper.toOptionalDto(candidateEntity);
    }

    @Override
    public List<CandidateDto> getAllCandidates() {
        List<CandidateEntity> entities = candidateRepository.findAll();
        if (entities.isEmpty() || entities ==null)
            throw new Errors("Not exist candidate register");
        return candidateMapper.toDtoList(entities);
    }

    @Override
    public CandidateDto updateCandidate(Long id, CandidateDto candidateDto) {
        isValidateCandidate(candidateDto);
        Optional<CandidateEntity> existingCandidateOptional = candidateRepository.findById(id);

        if (existingCandidateOptional.isPresent()) {
            CandidateEntity existingCandidate = existingCandidateOptional.get();

            existingCandidate.setName(candidateDto.getName());
            existingCandidate.setGender(candidateDto.getGender());
            existingCandidate.setSalaryExpected(candidateDto.getSalaryExpected());
            existingCandidate.setPhone(candidateDto.getPhone());

            if (candidateDto.getStatusId() != null) {
                Optional<StatusEntity> statusOptional = statusRepository.findById(candidateDto.getStatusId());
                statusOptional.ifPresent(existingCandidate::setStatus);
            }
            existingCandidate.setUpdatedAt(LocalDate.now());
            CandidateEntity updatedEntity = candidateRepository.save(existingCandidate);

            return candidateMapper.toDto(updatedEntity);
        } else {
            throw new Errors("Candidate with id " + id + " not found");
        }
    }

    @Override
    public void deleteCandidate(Long id) {
        candidateRepository.findById(id)
                .orElseThrow(() -> new Errors("OrderItem not found by " + id));
        candidateRepository.deleteById(id);
    }

    public void isValidateCandidate(CandidateDto candidateDto){
        if(candidateDto.getName()==null || candidateDto.getName().isEmpty())
            throw new Errors("name of candidate is required");
        if (candidateDto.getGender().equals(null) )
            throw new Errors("Gender of candidate is required");
    }

}
