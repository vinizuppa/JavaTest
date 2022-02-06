package com.projeto.sigabem.rest.controllers;

import com.projeto.sigabem.domain.services.FreteService;
import com.projeto.sigabem.rest.dtos.FreteInputDTO;
import com.projeto.sigabem.rest.dtos.FreteOutputDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api")
public class FreteController {

    @Autowired
    FreteService freteService;

    @PostMapping("/fretes")
    public ResponseEntity<FreteOutputDTO> insertFrete(@Valid @RequestBody FreteInputDTO freteInputDTO) {
        FreteOutputDTO freteOutputDTO = freteService.insert(freteInputDTO);

        return new ResponseEntity<>(freteOutputDTO, HttpStatus.CREATED);
    }

}
