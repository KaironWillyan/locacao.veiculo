package com.locacao.gerencia.repositories;

import com.locacao.gerencia.entities.Setor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {
    @Autowired
    Setor getById(Long id);
    Setor getByNome(String nome);

    @Query(value = "SELECT * FROM  Setores WHERE nome = ?", nativeQuery = true)
    List<Setor> findByNome(String nome);

}
