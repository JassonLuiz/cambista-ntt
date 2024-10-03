package br.cambista.adapters.controller;

import br.cambista.adapters.controller.request.ClienteRequest;
import br.cambista.adapters.controller.response.ClienteResponse;
import br.cambista.adapters.mapper.ClienteMapper;
import br.cambista.domains.usecases.ClienteUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private static final Logger log = LoggerFactory.getLogger(ClienteController.class);
    @Autowired
    private ClienteUseCase useCase;
    @Autowired
    private ClienteMapper mapper;

    @PostMapping()
    public ResponseEntity<ClienteResponse> criarCliente(@RequestBody ClienteRequest clienteRequest){
        log.info("Criando Cliente.");
        var model = this.mapper.toModel(clienteRequest);
        model = this.useCase.salvar(model);
        var resonse = this.mapper.toResponse(model);
        return ResponseEntity.ok(resonse);
    }
}
