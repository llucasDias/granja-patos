package com.lucas.granjapatos.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class SolicitarVenda  {

    private Integer idCliente;
    private Integer idVendedor;
    private Set<Integer> patosIds;


    public SolicitarVenda() {

    }

    public SolicitarVenda(Integer idCliente, Integer idVendedor, Set<Integer> patosIds) {
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.patosIds = patosIds;
    }

    ///  GETTERS AND SETTERS

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Set<Integer> getPatosIds() {
        return patosIds;
    }

    public void setPatosIds(Set<Integer> patosIds) {
        this.patosIds = patosIds;
    }

}
