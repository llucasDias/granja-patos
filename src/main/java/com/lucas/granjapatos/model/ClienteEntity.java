package com.lucas.granjapatos.model;


import jakarta.persistence.*;

import java.util.List;

@Entity (name = "CLIENTE")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME")
    private String nomeCliente;

    @Column(name = "DESCONTO")
    private boolean desconto;


}
