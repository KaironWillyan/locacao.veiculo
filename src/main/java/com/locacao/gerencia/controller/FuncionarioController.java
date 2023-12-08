package com.locacao.gerencia.controller;

import com.locacao.gerencia.entities.Funcionario;
import com.locacao.gerencia.repositories.FuncionarioRepository;
import com.locacao.gerencia.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/funcionario")
    public List<Funcionario> GetFuncionario(){
        return funcionarioService.GetFuncionario();
    }

    @GetMapping(value = "/funcionario/{id}")
    public ResponseEntity<Funcionario> GetFuncionarioById(@PathVariable(value = "id") Long id){
        Funcionario funcionario = funcionarioService.GetFuncionarioById(id);
        if(funcionario ==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Funcionário não encontrado."
            );
        }
            return ResponseEntity.ok(funcionario);
    }

    @PostMapping("/funcionario")
    public Funcionario PostFuncionario(@Validated @RequestBody Funcionario funcionario){
        return funcionarioService.PostFuncionario(funcionario);
    }

    @PutMapping("/funcionario/{id}")
    public ResponseEntity<Funcionario> PutFuncionario(@PathVariable(value = "id") Long id, @Validated @RequestBody Funcionario newFuncionario)
    {
        Funcionario funcionario = funcionarioService.GetFuncionarioById(id);
        if(funcionario==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "funcionario não encontrado."
            );
        }
        funcionarioService.PutFuncionario(id, funcionario);
        return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
    }

    @DeleteMapping("/funcionario/{id}")
    public ResponseEntity<Funcionario> Deletefuncionario(@PathVariable(value = "id") Long id){
        Funcionario funcionario = funcionarioService.GetFuncionarioById(id);
        if (funcionario == null){

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "funcionario não encontrado."
            );
        }
        return new ResponseEntity<Funcionario>(HttpStatus.OK);
    }

}
