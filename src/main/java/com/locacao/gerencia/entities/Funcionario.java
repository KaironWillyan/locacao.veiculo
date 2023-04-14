package com.locacao.gerencia.entities;

import jakarta.persistence.*;
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_setor", nullable = false)
    private Setor setor;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String tipo_cnh;

    @Column(nullable = false)
    private String telefone;


    public Funcionario(){}

    public  Funcionario(String nome, String cpf, String tipo_cnh, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.tipo_cnh = tipo_cnh;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Setor getSetor(){
        return setor;
    }

    public void setSetores(Setor setor){
        this.setor = setor;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getTipo_cnh(){
        return tipo_cnh;
    }
    public void setTipo_cnh(String tipo_cnh){
        this.tipo_cnh = tipo_cnh;
    }

    public  String getTelefone(){
        return  telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
}
