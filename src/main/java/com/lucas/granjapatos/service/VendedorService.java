package com.lucas.granjapatos.service;

import com.lucas.granjapatos.dto.CadastroVendedor;
import com.lucas.granjapatos.model.VendedorEntity;
import com.lucas.granjapatos.repository.VendedorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/** Service para cadastro dos Vendedores **/

@Service
public class VendedorService {

    private final VendedorRepository vendedorRepository;

    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @Transactional
    public VendedorEntity cadastrarVendedor(CadastroVendedor dto) {


        // Duplicidade CPF
        if (vendedorRepository.existsByCpf(dto.cpf())) {
            throw new IllegalArgumentException("Já existe um vendedor cadastrado com esse CPF");
        }

        // Duplicidade Matricula
        if (vendedorRepository.existsByMatricula(dto.matricula())) {
            throw new IllegalArgumentException("Já existe um vendedor cadastro com essa matrícula");
        }

        VendedorEntity vendedor = new VendedorEntity();

        vendedor.setNomeVendedor(dto.nome());
        vendedor.setCpf(dto.cpf());
        vendedor.setMatricula(dto.matricula());


        // Persiste o vendedor no banco
        return vendedorRepository.save(vendedor);
    }

}
