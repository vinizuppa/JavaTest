package com.projeto.sigabem.rest.dtos;

import com.projeto.sigabem.rest.validators.annotations.CepValidation;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class FreteInputDTO {

    @NotNull(message = "Peso obrigatório")
    @Positive(message = "Peso deve ser maior que 0")
    private double peso;

    @CepValidation
    private String cepOrigem;

    @CepValidation
    private String cepDestino;

    @NotBlank
    private String nomeDestinatario;

}
