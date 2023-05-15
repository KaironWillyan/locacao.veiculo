package com.locacao.gerencia.repositories;

import com.locacao.gerencia.entities.Locar;
import com.locacao.gerencia.entities.Locar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocarRepository extends JpaRepository<Locar, Long> {
    Optional<Locar> findById(Long id);
}
