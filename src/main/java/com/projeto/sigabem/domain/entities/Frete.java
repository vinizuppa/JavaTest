package com.projeto.sigabem.domain.entities;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "TB_Frete")
public class Frete implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long freteId;
    private String cepOrigem;
    private String cepDestino;
    private String nomeDestinatario;
    private LocalDate dataPrevistaEntrega;
    private LocalDate dataConsulta;
    private double peso;
    private double vlTotalFrete;



}
