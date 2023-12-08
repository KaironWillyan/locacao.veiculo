package com.locacao.gerencia.services;


import com.locacao.gerencia.entities.Veiculo;
import com.locacao.gerencia.repositories.VeiculoRepository;
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
public class VeiculoService {

        @Autowired
        private VeiculoRepository veiculoRepository;

        public List<Veiculo> Getveiculo(){
            return veiculoRepository.findAll();
        }

        public Veiculo GetveiculoById(Long id){
           return veiculoRepository.findById(id).orElse(null);
        }


        public Veiculo Postveiculo(Veiculo veiculo){
            return veiculoRepository.save(veiculo);
        }

        public Veiculo Putveiculo(Long id, Veiculo newVeiculo)
        {
            if(!veiculoRepository.existsById(id)) return null;
            return veiculoRepository.saveAndFlush(newVeiculo);
        }

        public Veiculo Deleteveiculo( Long id){
            Optional<Veiculo> veiculo = veiculoRepository.findById((id));
            if (!veiculo.isPresent()) return null;
            veiculoRepository.delete(veiculo.get());
            return veiculo.get();
        }
}
