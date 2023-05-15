package com.locacao.gerencia.controller;


import com.locacao.gerencia.entities.Setor;
import com.locacao.gerencia.repositories.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080}")
public class SetorController {
    @Autowired
    private SetorRepository setorRepository;

    @GetMapping("/setor")
    public List<Setor> GetSetor(){
        return setorRepository.findAll();
    }

    @GetMapping("/setor/{id}")
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
//    public ResponseEntity<List<Setor>> GetSetorByNome(@RequestParam String nome){
//        List<Setor> setor = setorRepository.findByNome(nome);
//        if (setor != null){
//            return new ResponseEntity<Setor>(setor.get(), HttpStatus.OK);
//        }
//        throw new ResponseStatusException(
//          HttpStatus.NOT_FOUND, "Setor não encontrado."
//        );
//    }


    @PostMapping("/setor")
    public Setor PostSetor(@Validated @RequestBody Setor setor){
        return setorRepository.save(setor);
    }

    @PostMapping("/setor/{id}")
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

    @DeleteMapping("/setor/{id}")
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

    @DeleteMapping("/setor")
    public ResponseEntity<Setor> DeleteAllSetores(){
        setorRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
