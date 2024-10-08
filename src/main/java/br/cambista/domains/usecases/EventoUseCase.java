package br.cambista.domains.usecases;

import br.cambista.adapters.integration.jpa.EventoRepository;
import br.cambista.adapters.integration.mapper.EventoEntityMapper;
import br.cambista.domains.models.Evento;
import br.cambista.domains.models.Ingresso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class EventoUseCase {

    @Autowired
    private EventoRepository repository;

    @Autowired
    private EventoEntityMapper eventoEntityMapper;

    public Evento salvar(Evento evento){
        var ingressos = new ArrayList<Ingresso>();
        for (int i = 0; i < evento.getTotalIngressos(); i++){
            ingressos.add(Ingresso.builder()
                    .build());
        }
        evento.setIngressos(ingressos);
        evento.setDataCriacao(LocalDateTime.now());
        var entity = repository.save(this.eventoEntityMapper.toEntity(evento));
        var model = this.eventoEntityMapper.toModel(entity);

        return model;
    }

    public Evento buscarPorId(String id){
        return null;
    }
}
