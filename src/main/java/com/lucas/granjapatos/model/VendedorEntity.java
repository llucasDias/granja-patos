package com.lucas.granjapatos.model;


import jakarta.persistence.*;
import org.hibernate.validator.constraints.br.CPF;

@Entity (name = "VENDEDOR")
public class VendedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME")
    private String nomeVendedor;

    @Column(name = "MATRICULA")
    private Integer matricula;

    @Column(name = "CPF")
    private String cpf;




    ///  GETTERS AND SETTERS

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
