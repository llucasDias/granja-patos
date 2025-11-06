package com.lucas.granjapatos.dto;

import java.math.BigDecimal;
import java.util.List;

public record VendaPato(
        Integer idCliente,
        Integer idVendedor,
        List<Integer> idsPatos,
        BigDecimal total,
        BigDecimal desconto
) {
}
