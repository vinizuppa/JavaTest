package com.projeto.sigabem.domain.exceptions.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiErrorObject {

    private final String field;
    private final String message;
    private final Object parameter;
}
