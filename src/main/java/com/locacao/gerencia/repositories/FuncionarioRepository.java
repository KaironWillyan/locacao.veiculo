package com.locacao.gerencia.repositories;

import com.locacao.gerencia.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario getById(Long id);
}
