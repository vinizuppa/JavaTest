package com.projeto.sigabem.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValorCalculadoDTO {
    private double totalFrete;
    private LocalDate dataPrevistaEntrega;
}
