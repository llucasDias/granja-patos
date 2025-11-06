package com.lucas.granjapatos.repository;

import com.lucas.granjapatos.model.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendaRepository extends JpaRepository<VendaEntity, Integer> {

}
