package com.lucas.granjapatos.repository;

import com.lucas.granjapatos.model.PatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatoRepository extends JpaRepository<PatoEntity, Integer> {

@Query("SELECT COUNT (p) FROM PATO p WHERE p.maePato.id = :idMae")
    Long countByMae(Integer idMae);

}
