package com.locacao.gerencia.entities;


import jakarta.persistence.*;

import java.util.Calendar;

@Entity
public class Locar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long  id;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "id_operador")
    Operador operador;

    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    Veiculo veiculo;

    @Column(nullable = false)
    Calendar dt_locacao;

    @Column
    Calendar dt_entrega;

    @Column(nullable = false)
    Integer km_locacao;

    @Column
    Integer km_entrega;

    public Locar(){}

    public Locar(Long id, Funcionario funcionario, Operador operador, Veiculo veiculo, Calendar dt_locacao, Calendar dt_entrega, Integer km_locacao, Integer km_entrega) {
        this.id = id;
        this.funcionario = funcionario;
        this.operador = operador;
        this.veiculo = veiculo;
        this.dt_locacao = dt_locacao;
        this.dt_entrega = dt_entrega;
        this.km_locacao = km_locacao;
        this.km_entrega = km_entrega;
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

    public Calendar getDt_locacao() {
        return dt_locacao;
    }

    public void setDt_locacao(Calendar dt_locacao) {
        this.dt_locacao = dt_locacao;
    }

    public Calendar getDt_entrega() {
        return dt_entrega;
    }

    public void setDt_entrega(Calendar dt_entrega) {
        this.dt_entrega = dt_entrega;
    }

    public Integer getKm_locacao() {
        return km_locacao;
    }

    public void setKm_locacao(Integer km_locacao) {
        this.km_locacao = km_locacao;
    }

    public Integer getKm_entrega() {
        return km_entrega;
    }

    public void setKm_entrega(Integer km_entrega) {
        this.km_entrega = km_entrega;
    }
}
