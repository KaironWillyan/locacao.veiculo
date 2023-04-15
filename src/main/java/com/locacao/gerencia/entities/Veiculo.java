package com.locacao.gerencia.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private String cor;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String tipo_combustivel;

    @OneToMany(mappedBy = "veiculo")
    private List<Locar> locacao;

    public Veiculo() {
    }

    public Veiculo(Long id, String placa, String cor, String modelo, String tipo_combustivel) {
        this.id = id;
        this.placa = placa;
        this.cor = cor;
        this.modelo = modelo;
        this.tipo_combustivel = tipo_combustivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo_combustivel() {
        return tipo_combustivel;
    }

    public void setTipo_combustivel(String tipo_combustivel) {
        this.tipo_combustivel = tipo_combustivel;
    }
}
