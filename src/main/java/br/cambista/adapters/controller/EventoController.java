package br.cambista.adapters.controller;

import br.cambista.adapters.controller.request.EventoRequest;
import br.cambista.adapters.controller.response.EventoResponse;
import br.cambista.adapters.mapper.EventoMapper;
import br.cambista.domains.usecases.EventoUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    private static final Logger log = LoggerFactory.getLogger(EventoController.class);
    @Autowired
    private EventoUseCase useCase;
    @Autowired
    private EventoMapper mapper;

    @PostMapping
    public ResponseEntity<EventoResponse> criarEvento(@RequestBody EventoRequest eventoRequest){
        //Criar a estrutura que salva o evento
        log.info("Teste");
        var model = this.mapper.toModel(eventoRequest);
        model = this.useCase.salvar(model);
        var response = this.mapper.toResponse(model);
        return ResponseEntity.ok(response);
    }
}
