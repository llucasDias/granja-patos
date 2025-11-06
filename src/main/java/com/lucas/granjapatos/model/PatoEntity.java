package com.lucas.granjapatos.model;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity (name = "PATO")
public class PatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "NOME")
    private String nomePato;

    @Column(name = "VALOR")
    private BigDecimal valorPato;

    @ManyToOne
    @JoinColumn(name = "ID_MAE")
    private PatoEntity maePato;

    @OneToMany (mappedBy = "maePato")
    private List<PatoEntity> filhos;


    ///  GETTERS AND SETTERS
    public PatoEntity getMaePato() {
        return maePato;
    }

    public void setMaePato(PatoEntity maePato) {
        this.maePato = maePato;
    }

    public BigDecimal getValorPato() {
        return valorPato;
    }

    public void setValorPato(BigDecimal valorPato) {
        this.valorPato = valorPato;
    }

    public String getNomePato() {
        return nomePato;
    }

    public void setNomePato(String nomePato) {
        this.nomePato = nomePato;
    }

    public List<PatoEntity> getFilhos() {
        return filhos;
    }

    public void setFilhos(List<PatoEntity> filhos) {
        this.filhos = filhos;
    }



}
