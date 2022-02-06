package com.projeto.sigabem.domain.services;

import com.gtbr.domain.Cep;
import com.projeto.sigabem.rest.converters.FreteConverter;
import com.projeto.sigabem.rest.dtos.FreteInputDTO;
import com.projeto.sigabem.rest.dtos.FreteOutputDTO;
import com.projeto.sigabem.rest.dtos.ValorCalculadoDTO;
import com.projeto.sigabem.domain.entities.Frete;
import com.projeto.sigabem.domain.repositories.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class FreteService {

    @Autowired
    FreteRepository freteRepository;

    @Autowired
    FreteConverter freteConverter;

    @Autowired
    CalculoFreteService calculoFreteService;

    @Autowired
    ViaCepService viaCepService;

    @Transactional
    public FreteOutputDTO insert(FreteInputDTO objDto) {
        Frete frete = freteConverter.toEntity(objDto);
        Cep cepDestino = viaCepService.findCep(frete.getCepDestino());
        Cep cepOrigem = viaCepService.findCep(frete.getCepOrigem());
        ValorCalculadoDTO valorCalculadoDTO = calculoFreteService.calculaFrete(frete, cepDestino, cepOrigem);
        frete.setVlTotalFrete(valorCalculadoDTO.getTotalFrete());
        frete.setDataPrevistaEntrega(valorCalculadoDTO.getDataPrevistaEntrega());
        frete.setDataConsulta(LocalDate.now());
        freteRepository.save(frete);

        return freteConverter.toDTO(frete);
    }
}
