package com.locacao.gerencia.controller;


import com.locacao.gerencia.entities.Setor;
import com.locacao.gerencia.repositories.SetorRepository;
import com.locacao.gerencia.service.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class SetorController {
    @Autowired
    private SetorRepository setorRepository;
    @Autowired
    private SetorService setorService;


    @RequestMapping(value = "/setor", method = RequestMethod.GET)
    public List<Setor> GetSetor(){
        return setorRepository.findAll();
    }

    @RequestMapping(value = "/setor/{id}", method = RequestMethod.GET)
    public ResponseEntity<Setor> GetById(@PathVariable(value = "id") Long id)
    {
        Optional<Setor> setor = setorRepository.findById(id);
        if(setor.isPresent()) {
            return new ResponseEntity<Setor>(setor.get(), HttpStatus.OK);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Setor não encontrado."
        );
    }

//    @RequestMapping(value = "/setores/{nome}", method = RequestMethod.GET)
//    public ResponseEntity<List<Setores>> GetSetorByNome(@RequestParam String nome){
//        List<Setores> setor = setoresService.findByNome(nome);
//        if (setor != null){
//            return new ResponseEntity<Setores>(setor.get(), HttpStatus.OK);
//        }
//        throw new ResponseStatusException(
//          HttpStatus.NOT_FOUND, "Setor não encontrado."
//        );
//    }


    @RequestMapping(value = "/setor", method = RequestMethod.POST)
    public Setor PostSetor(@Validated @RequestBody Setor setor){
        return setorRepository.save(setor);
    }

    @RequestMapping(value = "/setor/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Setor> PutSetor(@PathVariable(value = "id") Long id, @Validated @RequestBody Setor newSetor)
    {
        Optional<Setor> oldSetor = setorRepository.findById(id);
        if(oldSetor.isPresent()){
            Setor setor = oldSetor.get();
            setor.setNome(newSetor.getNome());
            setorRepository.save(setor);
            return new ResponseEntity<Setor>(setor, HttpStatus.OK);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Setor não encontrado."
        );
    }

    @RequestMapping(value = "/setor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Setor> DeleteSetor(@PathVariable(value = "id") Long id){
        Optional<Setor> setor = setorRepository.findById((id));
        if (setor.isPresent()){
            setorRepository.delete(setor.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Setor não encontrado."
        );
    }

    @RequestMapping(value = "/setor", method = RequestMethod.DELETE)
    public ResponseEntity<Setor> DeleteAllSetores(){
        setorRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
