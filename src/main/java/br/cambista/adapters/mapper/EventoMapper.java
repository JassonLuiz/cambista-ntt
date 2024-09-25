package br.cambista.adapters.mapper;

import br.cambista.adapters.controller.request.EventoRequest;
import br.cambista.adapters.controller.response.EventoResponse;
import br.cambista.domains.models.Evento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventoMapper {

    Evento toModel(EventoRequest eventoRequest);

    EventoResponse toResponse(Evento evento);
}
