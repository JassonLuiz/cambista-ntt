package br.cambista.domains.usecases;

import br.cambista.domains.models.Evento;
import br.cambista.domains.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoUseCase {

    @Autowired
    private EventoRepository repository;

    public Evento salvar(Evento evento){
        return repository.save(evento);
    }

    public Evento buscarPorId(String id){
        return null;
    }
}
