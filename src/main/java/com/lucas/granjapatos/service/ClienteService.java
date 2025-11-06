package com.lucas.granjapatos.service;

import com.lucas.granjapatos.dto.CadastroCliente;
import com.lucas.granjapatos.model.ClienteEntity;
import com.lucas.granjapatos.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/** Service para cadastro de Cliente **/

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @Transactional
    public ClienteEntity cadastrarCliente(CadastroCliente dto) {
        ClienteEntity cliente = new ClienteEntity();


        cliente.setNomeCliente(dto.nomeCliente());
        cliente.setDesconto(dto.desconto());

        // Salvar no repositório
        return clienteRepository.save(cliente);


    }

}
