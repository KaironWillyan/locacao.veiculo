package com.locacao.gerencia.services;


import com.locacao.gerencia.entities.Operador;
import com.locacao.gerencia.repositories.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class OperadorService {
    @Autowired
    private OperadorRepository operadorRepository;

    public List<Operador> GetOperador (){
        return operadorRepository.findAll();
    }

    public Operador  GetOperadorById(Long id){
      return operadorRepository.findById(id).orElse(null);
    }

    public Operador PostOperador(@Validated @RequestBody Operador operador){
        return operadorRepository.save(operador);
    }

    public Operador  PutOperador( Long id, Operador newOperador){
        Optional<Operador> oldOperador = operadorRepository.findById(id);
        if(!oldOperador.isPresent()) return null;
        return operadorRepository.save(newOperador);
    }

    public Operador DeleteOperador(Long id){
        Optional<Operador> operador = operadorRepository.findById(id);

        if (!operador.isPresent()) return null;

        operadorRepository.delete(operador.get());
        return operador.get();
    }
}
