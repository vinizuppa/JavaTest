package com.projeto.sigabem.domain.exceptions.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ApiErrorResponse {

    private final int code;
    private final String message;
    private final String status;
    private final List<ApiErrorObject> errors;
}