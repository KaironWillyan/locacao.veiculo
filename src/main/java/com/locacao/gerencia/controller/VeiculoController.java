package com.locacao.gerencia.controller;


import com.locacao.gerencia.entities.Veiculo;
import com.locacao.gerencia.repositories.VeiculoRepository;
import com.locacao.gerencia.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class VeiculoController {

        @Autowired
        private VeiculoService veiculoService;

        @GetMapping(value="/veiculo")
        public List<Veiculo> Getveiculo(){
            return veiculoService.Getveiculo();
        }

        @GetMapping(value = "/veiculo/{id}")
        public ResponseEntity<Veiculo> GetveiculoById(@PathVariable(value = "id") Long id){
            Veiculo veiculo = veiculoService.GetveiculoById(id);
            if(veiculo== null){
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Veículo não encontrado."
                );
            }
            return new ResponseEntity<Veiculo>(veiculo, HttpStatus.OK);
        }

        @PostMapping(value = "/veiculo")
        public Veiculo Postveiculo(@Validated @RequestBody Veiculo veiculo){
            return veiculoService.Postveiculo(veiculo);
        }

        @PutMapping(value = "/veiculo/{id}")
        public ResponseEntity<Veiculo> Putveiculo(@PathVariable(value = "id") Long id, @Validated @RequestBody Veiculo newVeiculo)
        {
            Veiculo veiculo = veiculoService.Putveiculo(id, newVeiculo);
            if(veiculo == null) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Veiuculo não encontrada!"
                );
            }

            return ResponseEntity.ok().body(veiculo);
        }

        @DeleteMapping(value = "/veiculo/{id}")
        public ResponseEntity<Veiculo> Deleteveiculo(@PathVariable(value = "id") Long id){
            Veiculo veiculo = veiculoService.Deleteveiculo(id);
            if (veiculo == null){
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "veiculo não encontrado."
                );
            }
            return ResponseEntity.ok(veiculo);
        }
}
