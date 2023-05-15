package com.locacao.gerencia.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.metamodel.mapping.internal.GeneratedValuesProcessor;

import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Locar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long  id;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "id_operador")
    private Operador operador;

    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;

    @Column(nullable = false)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Timestamp dtLocacao;

    @Column
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Timestamp dtEntrega;

    @Column(nullable = false)
    Integer kmLocacao;

    @Column
    Integer kmEntrega;

    public Locar(){}

    public Locar(Timestamp dtLocacao, Timestamp dtEntrega, Integer kmLocacao, Integer kmEntrega) {
        this.dtLocacao = dtLocacao;
        this.dtEntrega = dtEntrega;
        this.kmLocacao = kmLocacao;
        this.kmEntrega = kmEntrega;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Timestamp getDtLocacao() {
        return dtLocacao;
    }

    public void setDtLocacao(Timestamp dtLocacao) {
        this.dtLocacao = dtLocacao;
    }

    public Timestamp getDtEntrega() {
        return dtEntrega;
    }

    public void setDtEntrega(Timestamp dtEntrega) {
        this.dtEntrega = dtEntrega;
    }

    public Integer getKmLocacao() {
        return kmLocacao;
    }

    public void setKmLocacao(Integer kmLocacao) {
        this.kmLocacao = kmLocacao;
    }

    public Integer getKmEntrega() {
        return kmEntrega;
    }

    public void setKmEntrega(Integer kmEntrega) {
        this.kmEntrega = kmEntrega;
    }
}