package poo2.estoque.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @DateTimeFormat(pattern = "yyy-MM-dd-HH.mm.ss")
    private LocalDate dataDeInclusao;

    @DateTimeFormat(pattern = "yyy-MM-dd-HH.mm.ss")
    private LocalDate dataDeAlteracao;

    private String descricao;
    private Long codigoSubclasse;
    private Double valor;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataDeInclusao() {
        return dataDeInclusao;
    }

    public void setDataDeInclusao(LocalDate dataDeInclusao) {
        this.dataDeInclusao = dataDeInclusao;
    }

    public LocalDate getDataDeAlteracao() {
        return dataDeAlteracao;
    }

    public void setDataDeAlteracao(LocalDate dataDeAlteracao) {
        this.dataDeAlteracao = dataDeAlteracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getCodigoSubclasse() {
        return codigoSubclasse;
    }

    public void setCodigoSubclasse(Long codigoSubclasse) {
        this.codigoSubclasse = codigoSubclasse;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Produto() {
    }

    public Produto(Long codigo, LocalDate dataDeInclusao, LocalDate dataDeAlteracao, String descricao,
            Long codigoSubclasse, Double valor) {
        this.codigo = codigo;
        this.dataDeInclusao = dataDeInclusao;
        this.dataDeAlteracao = dataDeAlteracao;
        this.descricao = descricao;
        this.codigoSubclasse = codigoSubclasse;
        this.valor = valor;
    }

}
