package com.locacao.gerencia.repositories;


import com.locacao.gerencia.entities.Operador;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperadorRepository extends JpaRepository<Operador, Long> {
    Operador findByEmail(String email);
}
