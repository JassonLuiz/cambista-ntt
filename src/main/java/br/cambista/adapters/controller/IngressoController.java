package br.cambista.adapters.controller;

import br.cambista.domains.models.Cliente;
import br.cambista.domains.models.Ingresso;
import br.cambista.domains.repository.ClienteRepository;
import br.cambista.domains.repository.IngressoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ingressos")
public class IngressoController {

    private static final Logger log = LoggerFactory.getLogger(IngressoController.class);
    @Autowired
    private IngressoRepository ingressoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/reservar/{idIngresso}/{idCliente}")
    public String reservarIngresso(@PathVariable Long idIngresso, @PathVariable Long idCliente){
        log.info("Reservando ingresso.");
        Optional<Ingresso> ingresso = ingressoRepository.findById(idIngresso);
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        String mensagem = ingresso.get().reservar(cliente.get());
        ingressoRepository.save(ingresso.get());
        return mensagem;
    }

    @PostMapping("/paga/{idIngresso}")
    public String pagarIngresso(@PathVariable Long idIngresso){
        Optional<Ingresso> ingresso = ingressoRepository.findById(idIngresso);
        String mensagem = ingresso.get().pagar();
        ingressoRepository.save(ingresso.get());
        return mensagem;
    }
}
