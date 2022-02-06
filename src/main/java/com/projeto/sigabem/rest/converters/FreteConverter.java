package com.projeto.sigabem.rest.converters;

import com.projeto.sigabem.rest.dtos.FreteInputDTO;
import com.projeto.sigabem.rest.dtos.FreteOutputDTO;
import com.projeto.sigabem.domain.entities.Frete;
import org.springframework.stereotype.Component;

@Component
public class FreteConverter {

    public Frete toEntity(FreteInputDTO objDto) {
        Frete frete = new Frete();
        frete.setCepDestino(objDto.getCepDestino());
        frete.setCepOrigem(objDto.getCepOrigem());
        frete.setNomeDestinatario(objDto.getNomeDestinatario());
        frete.setPeso(objDto.getPeso());

        return frete;
    }

    public FreteOutputDTO toDTO(Frete frete) {
        FreteOutputDTO freteOutputDTO = new FreteOutputDTO();
        freteOutputDTO.setCepDestino(frete.getCepDestino());
        freteOutputDTO.setCepOrigem(frete.getCepOrigem());
        freteOutputDTO.setPeso(frete.getPeso());
        freteOutputDTO.setNomeDestinatario(frete.getNomeDestinatario());
        freteOutputDTO.setVlTotalFrete(frete.getVlTotalFrete());
        freteOutputDTO.setDataConsulta(frete.getDataConsulta());
        freteOutputDTO.setDataPrevistaEntrega(frete.getDataPrevistaEntrega());
        return freteOutputDTO;
    }
}
