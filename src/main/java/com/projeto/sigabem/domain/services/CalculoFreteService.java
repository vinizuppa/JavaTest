package com.projeto.sigabem.domain.services;

import com.gtbr.domain.Cep;
import com.projeto.sigabem.rest.dtos.ValorCalculadoDTO;
import com.projeto.sigabem.domain.entities.Frete;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class CalculoFreteService {

           /* CEPs com DDDs iguais tem 50% de desconto no valor do frete e entrega prevista de 1 dia
            CEPs de estados iguais tem 75% de desconto no valor do frete e entrega prevista de 3 dias
            CEPs de estados diferentes não deve ser aplicado o desconto no valor do frete e entrega prevista de 10 dias
            O valor do frete é cobrado pelo peso da encomenda, o valor para cada KG é R$1,00 */

    private static final double valorPorKg = 1;

    public ValorCalculadoDTO calculaFrete(Frete frete, Cep cepDestino, Cep cepOrigem) {

        double valorFinal;
        double desconto = 1;
        int entrega = 10;

        if (cepDestino.getDdd().equals(cepOrigem.getDdd())) {
            desconto = 0.5;
            entrega = 1;
        } else if (cepDestino.getUf().equals(cepOrigem.getUf())) {
            desconto = 1 - 0.75;
            entrega = 3;
        }

        valorFinal = valorPorKg * frete.getPeso() * desconto;

        return new ValorCalculadoDTO(valorFinal, LocalDate.now().plusDays(entrega));
    }
}
