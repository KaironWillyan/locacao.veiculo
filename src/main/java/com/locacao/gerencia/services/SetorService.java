package com.locacao.gerencia.services;


import com.locacao.gerencia.entities.Setor;
import com.locacao.gerencia.repositories.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SetorService {
    @Autowired
    private SetorRepository setorRepository;

    public List<Setor> GetSetor(){
        return setorRepository.findAll();
    }

    public Setor GetById( Long id)
    {
        return setorRepository.findById(id).orElse(null);
    }

    public Setor PostSetor(Setor setor){
        return setorRepository.save(setor);
    }

    public Setor PutSetor( Long id, Setor newSetor)
    {
        if(!setorRepository.existsById(id)) return null;
        return setorRepository.save(newSetor);
    }

    public Setor DeleteSetor(Long id){
        Optional<Setor> setor = setorRepository.findById((id));
        if (!setor.isPresent()){
            return null;
        }
        setorRepository.delete(setor.get());
        return setor.get();
    }

}
