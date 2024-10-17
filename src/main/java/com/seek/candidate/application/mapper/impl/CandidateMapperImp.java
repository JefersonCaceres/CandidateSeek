package com.seek.candidate.application.mapper.impl;

import com.seek.candidate.application.dto.CandidateDto;
import com.seek.candidate.application.mapper.CandidateMapper;
import com.seek.candidate.domain.data.CandidateEntity;
import com.seek.candidate.domain.data.StatusEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CandidateMapperImp implements CandidateMapper {

    @Override
    public CandidateEntity toEntity(CandidateDto dto) {
        if (dto == null) {
            return null;
        }
        CandidateEntity entity = new CandidateEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setGender(dto.getGender());
        entity.setSalaryExpected(dto.getSalaryExpected());
        entity.setPhone(dto.getPhone());

        // Aquí creamos un nuevo StatusEntity solo con el ID
        if (dto.getStatusId() != null) {
            StatusEntity statusEntity = new StatusEntity();
            statusEntity.setId(dto.getStatusId());
            entity.setStatus(statusEntity);
        }

        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }

    @Override
    public CandidateDto toDto(CandidateEntity entity) {
        if (entity == null) {
            return null;
        }
        return new CandidateDto(
                entity.getId(),
                entity.getName(),
                entity.getGender(),
                entity.getSalaryExpected(),
                entity.getPhone(),
                entity.getStatus() != null ? entity.getStatus().getId() : null,
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    @Override
    public Optional<CandidateDto> toOptionalDto(Optional<CandidateEntity> candidateEntity) {
        if (candidateEntity.isPresent()) {
            return Optional.of(toDto(candidateEntity.get()));
        }
        return Optional.empty();
    }


    @Override
    public List<CandidateEntity> toEntityList(List<CandidateDto> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CandidateDto> toDtoList(List<CandidateEntity> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
