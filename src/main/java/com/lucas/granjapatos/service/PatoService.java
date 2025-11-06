package com.lucas.granjapatos.service;

import com.lucas.granjapatos.dto.CadastroPato;
import com.lucas.granjapatos.model.PatoEntity;
import com.lucas.granjapatos.repository.PatoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

/** Service para cadastro dos Patos **/


@Service
public class PatoService {

    private final PatoRepository patoRepository;

    public PatoService(PatoRepository patoRepository) {
        this.patoRepository = patoRepository;
    }


    @Transactional
    public PatoEntity cadastrarPato(CadastroPato dto) {

        PatoEntity pato = new PatoEntity();
        pato.setNomePato(dto.nome());

        // Define mãe do pato
        if (dto.idMae() != null) {
            PatoEntity mae = patoRepository.findById(dto.idMae())
                    .orElseThrow(() -> new RuntimeException("Mãe não encontrada"));
            pato.setMaePato(mae);
        }

        // Calcula o valor do pato com base na quantidade de filhos
        BigDecimal valorPato = calcularValor(dto.idMae());
        pato.setValorPato(valorPato);

        // Persiste o pato no banco
        return patoRepository.save(pato);
    }


    /**  Calcula valor do pato baseado na quantidade de filhos da mãe  **/


    private BigDecimal calcularValor(Integer idMae) {
        if (idMae == null) {
            return BigDecimal.valueOf(70.00);
        }

        Long qtdFilhos = patoRepository.countByMae(idMae);

        if (qtdFilhos == 1) {
            return BigDecimal.valueOf(50.00);
        } else {
            return BigDecimal.valueOf(25.00);
        }
    }
}