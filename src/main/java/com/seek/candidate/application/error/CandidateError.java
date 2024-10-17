package com.seek.candidate.application.error;

public abstract class CandidateError extends RuntimeException {
    private String mensaje;

    public CandidateError(String message) {
        this.mensaje = message;
    }

    public String getMessage() {
        return mensaje;
    }
}
