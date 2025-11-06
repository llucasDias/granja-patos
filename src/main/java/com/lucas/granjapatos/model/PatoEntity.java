package com.lucas.granjapatos.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

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


}
