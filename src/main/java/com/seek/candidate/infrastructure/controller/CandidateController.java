package com.seek.candidate.infrastructure.controller;

import com.seek.candidate.application.dto.CandidateDto;
import com.seek.candidate.application.service.CandidateServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidates/")
public class CandidateController {
    private final CandidateServicePort candidateServicePort;

    public CandidateController(CandidateServicePort candidateServicePort) {
        this.candidateServicePort = candidateServicePort;
    }


    @PostMapping("save")
    public ResponseEntity<CandidateDto> createCandidate(@RequestBody CandidateDto candidateDto) {
        CandidateDto createdCandidate = candidateServicePort.createCandidate(candidateDto);
        return new ResponseEntity<>(createdCandidate, HttpStatus.CREATED);
    }

    @GetMapping("find/by/{id}")
    public ResponseEntity<CandidateDto> getCandidate(@PathVariable Long id) {
        Optional<CandidateDto> candidate = candidateServicePort.getCandidate(id);
        return candidate.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("list")
    public ResponseEntity<List<CandidateDto>> getAllCandidates() {
        List<CandidateDto> candidates = candidateServicePort.getAllCandidates();
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<CandidateDto> updateCandidate(@PathVariable Long id, @RequestBody CandidateDto candidateDto) {
        CandidateDto updatedCandidate = candidateServicePort.updateCandidate(id, candidateDto);
        return new ResponseEntity<>(updatedCandidate, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Long id) {
        candidateServicePort.deleteCandidate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
