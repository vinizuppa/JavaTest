package com.projeto.sigabem.infra;

import com.projeto.sigabem.domain.exceptions.ViaCepException;
import com.projeto.sigabem.domain.exceptions.models.ApiErrorObject;
import com.projeto.sigabem.domain.exceptions.models.ApiErrorResponse;
import com.projeto.sigabem.domain.exceptions.models.ApiExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<ApiErrorObject> errors = getErrors(ex);
        ApiErrorResponse errorResponse = getErrorResponse(ex, HttpStatus.BAD_REQUEST, errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private ApiErrorResponse getErrorResponse(MethodArgumentNotValidException ex, HttpStatus status, List<ApiErrorObject> errors) {
        return new ApiErrorResponse(status.value(),"Requisição possui campos inválidos",
                status.getReasonPhrase(), errors);
    }

    private List<ApiErrorObject> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ApiErrorObject(error.getField(), error.getDefaultMessage(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }

    @ExceptionHandler(ViaCepException.class)
    public ResponseEntity<ApiExceptionResponse> viaCep(ViaCepException e, HttpServletRequest request) {
        ApiExceptionResponse err = ApiExceptionResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.getMessage())
                .timeStamp(System.currentTimeMillis())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }

}