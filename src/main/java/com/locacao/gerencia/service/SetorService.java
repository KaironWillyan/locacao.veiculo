package com.locacao.gerencia.service;

import com.locacao.gerencia.entities.Setor;
import com.locacao.gerencia.repositories.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorService {
    private SetorService setorService;

    @Autowired
    private SetorRepository setorRepository;

    public List<Setor> findByNome(String nome){
        return setorRepository.findByNome(nome);
    }
}
