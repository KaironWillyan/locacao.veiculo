package com.locacao.gerencia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class LocacaoKey implements Serializable {

    @Column(name = "id_funcionario")
    Long funcionarioId;
    @Column(name = "id_Veiculo")
    Long veiculoId;
    @Column(name = "id_Operador")
    Long operadorId;


    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Long getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Long veiculoId) {
        this.veiculoId = veiculoId;
    }

    public Long getOperadorId() {
        return operadorId;
    }

    public void setOperadorId(Long operadorId) {
        this.operadorId = operadorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocacaoKey that)) return false;
        return Objects.equals(getFuncionarioId(), that.getFuncionarioId()) && Objects.equals(getVeiculoId(), that.getVeiculoId()) && Objects.equals(getOperadorId(), that.getOperadorId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFuncionarioId(), getVeiculoId(), getOperadorId());
    }
}
