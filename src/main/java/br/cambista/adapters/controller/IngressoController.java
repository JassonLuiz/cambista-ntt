package br.cambista.adapters.controller;

import br.cambista.adapters.controller.request.ReservarIngressoRequest;
import br.cambista.adapters.controller.response.IngressoResponse;
import br.cambista.adapters.mapper.IngressoMapper;
import br.cambista.domains.usecases.IngressoUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/v1/ingressos")
public class IngressoController {

    @Autowired
    private IngressoMapper ingressoMapper;

    @Autowired
    private IngressoUseCase ingressoUseCase;

    @PostMapping("/reservar")
    public ResponseEntity<?> reservarIngresso(@RequestBody ReservarIngressoRequest reservarIngressoRequest){
        log.info("Reservando");
        var request = this.ingressoMapper.toReservarIngressoModel(reservarIngressoRequest);
        var ingressos = this.ingressoUseCase.reservar(request);
        var response = ingressos.stream()
                .map(ingressoMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/pagar")
    public ResponseEntity<?> pagarIngressos(@RequestBody List<Long> idsIngressos){
        log.info("Pagando ingresso: {}", idsIngressos);
        var ingressos = this.ingressoUseCase.pagar(idsIngressos);
        var response = ingressos.stream().map(ingressoMapper::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cancelar")
    public ResponseEntity<?> cancelarIngressos(@RequestBody List<Long> idsIngressos){
        log.info("Pagando ingresso: {}", idsIngressos);
        var ingressos = this.ingressoUseCase.cancelar(idsIngressos);
        var response = ingressos.stream().map(ingressoMapper::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
