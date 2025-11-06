package com.lucas.granjapatos.repository;

import com.lucas.granjapatos.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer > {

}
