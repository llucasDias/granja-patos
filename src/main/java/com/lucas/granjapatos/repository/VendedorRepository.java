package com.lucas.granjapatos.repository;

import com.lucas.granjapatos.model.VendedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<VendedorEntity, Integer> {

    boolean existsByCpf(String cpf);

    boolean existsByMatricula(Integer matricula);
}
