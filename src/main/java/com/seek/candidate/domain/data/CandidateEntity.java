package com.seek.candidate.domain.data;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "candidate")
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    private Character gender;

    @Column(name = "salary_expected")
    private Double salaryExpected;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private StatusEntity status;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    public CandidateEntity() {
    }

    public CandidateEntity(Long id, String name, char gender, Double salaryExpected, String phone, StatusEntity status, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salaryExpected = salaryExpected;
        this.phone = phone;
        this.status = status;
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

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
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
