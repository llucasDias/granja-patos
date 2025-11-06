package com.lucas.granjapatos.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "VENDA")
public class VendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "ID_VENDEDOR")
    private VendedorEntity vendedor;

    @Column(name = "TOTAL_VENDA")
    private BigDecimal total;

    @Column(name = "DESCONTO")
    private BigDecimal desconto;

    @Column(name = "Data_Venda")
    private LocalDateTime dateTime;

    @ManyToMany
    @JoinTable(
            name = "PATO_VENDA",
            joinColumns = @JoinColumn(name = "ID_VENDA"),
            inverseJoinColumns = @JoinColumn(name = "ID_PATO")
    )

    private Set<PatoEntity> patos = new HashSet<>();


}
