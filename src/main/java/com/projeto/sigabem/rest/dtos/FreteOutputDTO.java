package com.projeto.sigabem.rest.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FreteOutputDTO {

    private String cepOrigem;
    private String cepDestino;
    private String nomeDestinatario;
    private LocalDate dataPrevistaEntrega;
    private LocalDate dataConsulta;
    private double peso;
    private double vlTotalFrete;

}
