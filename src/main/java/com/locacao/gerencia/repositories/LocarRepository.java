package com.locacao.gerencia.repositories;

import com.locacao.gerencia.entities.Locar;
import com.locacao.gerencia.entities.Locar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocarRepository extends JpaRepository<Locar, Long> {
    Optional<Locar> findById(Long id);
}
