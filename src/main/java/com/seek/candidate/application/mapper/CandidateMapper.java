package com.seek.candidate.application.mapper;

import com.seek.candidate.application.dto.CandidateDto;
import com.seek.candidate.domain.data.CandidateEntity;

import java.util.List;
import java.util.Optional;

public interface CandidateMapper {
    CandidateEntity toEntity(CandidateDto dto);
    CandidateDto toDto(CandidateEntity entity);
    Optional<CandidateDto>toOptionalDto(Optional<CandidateEntity> candidateEntity);
    List<CandidateEntity> toEntityList(List<CandidateDto> dtos);
    List<CandidateDto> toDtoList(List<CandidateEntity> entities);
}
