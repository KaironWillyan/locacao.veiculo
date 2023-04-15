package com.locacao.gerencia.entities;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Operador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "operador", targetEntity = Locar.class)
    private List<Locar> locar;

    @Column(nullable = false)
    private String email;
    @Column
    private String password;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String tipo;

    public Operador(){}
    public Operador(Long id, String nome, String cpf, String tipo, String email, String password) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.tipo = tipo;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
