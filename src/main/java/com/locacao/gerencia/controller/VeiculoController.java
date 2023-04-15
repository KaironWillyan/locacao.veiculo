package com.locacao.gerencia.controller;


import com.locacao.gerencia.entities.Veiculo;
import com.locacao.gerencia.repositories.VeiculoRepository;
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
        private VeiculoRepository veiculoRepository;

        @RequestMapping(value="/veiculo", method = RequestMethod.GET)
        public List<Veiculo> Getveiculo(){
            return veiculoRepository.findAll();
        }

        @RequestMapping(value = "/veiculo/{id}", method = RequestMethod.GET)
        public ResponseEntity<Veiculo> GetveiculoById(@PathVariable(value = "id") Long id){
            Optional<Veiculo> veiculo = veiculoRepository.findById(id);
            if(veiculo.isPresent()){
                return new ResponseEntity<Veiculo>(veiculo.get(), HttpStatus.OK);
            }
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Veículo não encontrado."
            );
        }


//    @RequestMapping(value = "/veiculo/{nome}", method = RequestMethod.GET)
//    public ResponseEntity<List<veiculo>> GetveiculoByNome(@RequestParam String nome){
//        List<veiculo> veiculo = veiculoService.findByNome(nome);
//        if (veiculo != null){
//            return new ResponseEntity<veiculo>(veiculo.get(), HttpStatus.OK);
//        }
//        throw new ResponseStatusException(
//          HttpStatus.NOT_FOUND, "veiculo não encontrado."
//        );
//    }


        @RequestMapping(value = "/veiculo", method = RequestMethod.POST)
        public Veiculo Postveiculo(@Validated @RequestBody Veiculo veiculo){
            return veiculoRepository.save(veiculo);
        }

        @RequestMapping(value = "/veiculo/{id}", method = RequestMethod.PUT)
        public ResponseEntity<Veiculo> Putveiculo(@PathVariable(value = "id") Long id, @Validated @RequestBody Veiculo newVeiculo)
        {
            Optional<Veiculo> oldVeiculo = veiculoRepository.findById(id);
            if(oldVeiculo.isPresent()){
                Veiculo veiculo = oldVeiculo.get();
                veiculo.setCor(newVeiculo.getCor());
                veiculo.setModelo(newVeiculo.getModelo());
                veiculo.setPlaca(newVeiculo.getPlaca());
                veiculo.setPlaca(newVeiculo.getPlaca());
                veiculoRepository.save(veiculo);
                return new ResponseEntity<Veiculo>(veiculo, HttpStatus.OK);
            }
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "veiculo não encontrado."
            );
        }

        @RequestMapping(value = "/veiculo/{id}", method = RequestMethod.DELETE)
        public ResponseEntity<Veiculo> Deleteveiculo(@PathVariable(value = "id") Long id){
            Optional<Veiculo> veiculo = veiculoRepository.findById((id));
            if (veiculo.isPresent()){
                veiculoRepository.delete(veiculo.get());
                return new ResponseEntity<>(HttpStatus.OK);
            }
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "veiculo não encontrado."
            );
        }

        @RequestMapping(value = "/veiculo", method = RequestMethod.DELETE)
        public ResponseEntity<Veiculo> DeleteAllVeiculo(){
            veiculoRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        }
}
