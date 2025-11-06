package com.lucas.granjapatos.controller;


import com.lucas.granjapatos.dto.CadastroCliente;
import com.lucas.granjapatos.model.ClienteEntity;
import com.lucas.granjapatos.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro")
public class ClienteController {

    private final ClienteService clienteService;



    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/cliente")
    public ResponseEntity<ClienteEntity> cadastrar (@RequestBody CadastroCliente dto) {
        ClienteEntity saved = clienteService.cadastrarCliente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

}
