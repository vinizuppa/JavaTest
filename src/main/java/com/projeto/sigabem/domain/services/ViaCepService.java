package com.projeto.sigabem.domain.services;

import com.gtbr.ViaCepClient;
import com.gtbr.domain.Cep;
import com.gtbr.utils.CEPUtils;
import com.projeto.sigabem.domain.exceptions.ViaCepException;
import org.springframework.stereotype.Service;

@Service
public class ViaCepService {

    public Cep findCep(String cep) {
        Cep returnedCep;
        try {
            returnedCep = ViaCepClient.findCep(CEPUtils.removeMascaraCep(cep));
        } catch (Exception e) {
            throw new ViaCepException("Erro ao se comunicar com o Via Cep");
        }
        if (returnedCep.getLocalidade() == null) {
            throw new ViaCepException("CEP inexistente");
        }
        return returnedCep;
    }
}
