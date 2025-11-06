package com.lucas.granjapatos.dto;

import java.math.BigDecimal;

public record CadastroPato(
        String nome,
        BigDecimal valor,
        Integer idMae
) {
}
