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



    ///  GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<PatoEntity> getPatos() {
        return patos;
    }

    public void setPatos(Set<PatoEntity> patos) {
        this.patos = patos;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public VendedorEntity getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorEntity vendedor) {
        this.vendedor = vendedor;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
}
