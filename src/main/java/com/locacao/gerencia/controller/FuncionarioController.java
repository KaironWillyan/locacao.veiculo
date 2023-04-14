package com.locacao.gerencia.controller;

import com.locacao.gerencia.entities.Funcionario;
import com.locacao.gerencia.repositories.FuncionarioRepository;
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
    private FuncionarioRepository   funcionarioRepository;

    @RequestMapping(value="/funcionario", method = RequestMethod.GET)
    public List<Funcionario> GetFuncionario(){
        return funcionarioRepository.findAll();
    }

    @RequestMapping(value = "/funcionario/{id}", method = RequestMethod.GET)
    public ResponseEntity<Funcionario> GetFuncionarioById(@PathVariable(value = "id") Long id){
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if(funcionario.isPresent()){
            return new ResponseEntity<Funcionario>(funcionario.get(), HttpStatus.OK);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Funcionário não encontrado."
        );
    }


//    @RequestMapping(value = "/Funcionario/{nome}", method = RequestMethod.GET)
//    public ResponseEntity<List<Funcionario>> GetfuncionarioByNome(@RequestParam String nome){
//        List<Funcionario> funcionario = FuncionarioService.findByNome(nome);
//        if (funcionario != null){
//            return new ResponseEntity<Funcionario>(funcionario.get(), HttpStatus.OK);
//        }
//        throw new ResponseStatusException(
//          HttpStatus.NOT_FOUND, "funcionario não encontrado."
//        );
//    }


    @RequestMapping(value = "/funcionario", method = RequestMethod.POST)
    public Funcionario PostFuncionario(@Validated @RequestBody Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    @RequestMapping(value = "/funcionario/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Funcionario> PutFuncionario(@PathVariable(value = "id") Long id, @Validated @RequestBody Funcionario newFuncionario)
    {
        Optional<Funcionario> oldFuncionario = funcionarioRepository.findById(id);
        if(oldFuncionario.isPresent()){
            Funcionario funcionario = oldFuncionario.get();
            funcionario.setNome(newFuncionario.getNome());
            funcionarioRepository.save(funcionario);
            return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "funcionario não encontrado."
        );
    }

    @RequestMapping(value = "/funcionario/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Funcionario> Deletefuncionario(@PathVariable(value = "id") Long id){
        Optional<Funcionario> funcionario = funcionarioRepository.findById((id));
        if (funcionario.isPresent()){
            funcionarioRepository.delete(funcionario.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "funcionario não encontrado."
        );
    }

    @RequestMapping(value = "/funcionario", method = RequestMethod.DELETE)
    public ResponseEntity<Funcionario> DeleteAllFuncionario(){
        funcionarioRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
