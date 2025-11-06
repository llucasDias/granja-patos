package com.lucas.granjapatos.service;


import com.lucas.granjapatos.dto.SolicitarVenda;
import com.lucas.granjapatos.model.ClienteEntity;
import com.lucas.granjapatos.model.PatoEntity;
import com.lucas.granjapatos.model.VendaEntity;
import com.lucas.granjapatos.model.VendedorEntity;
import com.lucas.granjapatos.repository.ClienteRepository;
import com.lucas.granjapatos.repository.PatoRepository;
import com.lucas.granjapatos.repository.VendaRepository;
import com.lucas.granjapatos.repository.VendedorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final ClienteRepository clienteRepository;
    private final PatoRepository patoRepository;
    private final VendedorRepository vendedorRepository;



    public VendaService(VendaRepository vendaRepository, ClienteRepository clienteRepository, PatoRepository patoRepository, VendedorRepository vendedorRepository) {
        this.vendaRepository = vendaRepository;
        this.clienteRepository = clienteRepository;
        this.patoRepository = patoRepository;
        this.vendedorRepository = vendedorRepository;
    }

    @Transactional
    public VendaEntity registrarVenda(SolicitarVenda dto) {


    }


