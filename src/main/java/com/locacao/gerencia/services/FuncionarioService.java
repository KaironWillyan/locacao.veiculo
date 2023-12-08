package com.locacao.gerencia.services;

import com.locacao.gerencia.entities.Funcionario;
import com.locacao.gerencia.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository   funcionarioRepository;

    public List<Funcionario> GetFuncionario(){
        return funcionarioRepository.findAll();
    }

    public Funcionario GetFuncionarioById(Long id){
      return funcionarioRepository.getById(id);
    }


    public Funcionario PostFuncionario(@Validated @RequestBody Funcionario funcionario){
        return funcionarioRepository.saveAndFlush(funcionario);
    }

    public Funcionario PutFuncionario(Long id,Funcionario newFuncionario)
    {
        Optional<Funcionario> oldFuncionario = funcionarioRepository.findById(id);
        Funcionario funcionario = new Funcionario();
        if(oldFuncionario.isPresent()) {
            funcionario = oldFuncionario.get();
            funcionario.setNome(newFuncionario.getNome());
            funcionario.setCpf(newFuncionario.getCpf());
            funcionario.setTelefone(newFuncionario.getTelefone());
            funcionario.setSetores(newFuncionario.getSetor());
            funcionario.setTipoCnh(newFuncionario.getTipoCnh());
            funcionarioRepository.save(funcionario);
        }
            return funcionario;
    }

    public Funcionario Deletefuncionario(Long id){
        Optional<Funcionario> funcionario = funcionarioRepository.findById((id));
        if (funcionario.isPresent()){
            return null;
        }
        funcionarioRepository.delete(funcionario.get());
        return funcionario.get();
    }

}
