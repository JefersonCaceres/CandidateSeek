package com.seek.candidate.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.seek.candidate.domain.data.StatusEntity;

import java.time.LocalDate;

public class CandidateDto {
    private Long id;
    private String name;
    private char gender;
    private Double salaryExpected;
    private String phone;
    private Long statusId;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public CandidateDto() {
    }

    public CandidateDto(Long id, String name, char gender, Double salaryExpected, String phone, Long statusId, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salaryExpected = salaryExpected;
        this.phone = phone;
        this.statusId = statusId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Double getSalaryExpected() {
        return salaryExpected;
    }

    public void setSalaryExpected(Double salaryExpected) {
        this.salaryExpected = salaryExpected;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
