package com.seek.candidate.application.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seek.candidate.application.error.CandidateError;
import com.seek.candidate.application.error.Errors;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {
    private final HttpServletRequest httpServletRequest;

    public Handler(HttpServletRequest httpServletRequest) {

        this.httpServletRequest = httpServletRequest;
    }

    private class ApiError {
        @JsonProperty
        private final String mensaje;
        private ApiError(String mensaje) {
            this.mensaje = mensaje;
        }
    }

    private ResponseEntity<ApiError> constructorError(HttpStatus httpStatus, Throwable ex) {
        final ApiError apiErrorResponse = new ApiError(ex.getMessage());
        return new ResponseEntity<>(apiErrorResponse, httpStatus);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiError> errorHandler(Throwable ex) {
        return constructorError(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }


    @ExceptionHandler({ Errors.class,})
    public ResponseEntity<ApiError> errorHandler(CandidateError ex) {
        final ApiError apiErrorResponse = new ApiError(ex.getMessage());
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }
}

