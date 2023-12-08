package com.locacao.gerencia.services;

import com.locacao.gerencia.entities.Locar;
import com.locacao.gerencia.repositories.LocarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LocarService {
    @Autowired
    private LocarRepository locarRepository;

    public List<Locar> getLocar (){
        return locarRepository.findAll();
    }

    public Locar getLocarById( Long id){
       return locarRepository.findById(id).orElse(null);
    }

    public Locar postLocar(Locar locacao){
        return locarRepository.save(locacao);
    }

    public Locar putLocar( Long id, Locar newLocar){
        Optional<Locar> locar = locarRepository.findById(id);
        if (locar.isPresent()){
            return locarRepository.save(newLocar);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Locacao não encontrado."
        );
    }
    public Locar deleteLocar(Long id){
        Optional<Locar> locar = locarRepository.findById(id);
        if (!locar.isPresent()){
            return null;
        }
            locarRepository.delete(locar.get());
            return locar.get();
    }
}
