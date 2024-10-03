package br.cambista.adapters.integration.mapper;

import br.cambista.adapters.integration.entity.EventoEntity;
import br.cambista.domains.models.Evento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventoEntityMapper {

    EventoEntity toEntity(Evento evento);

    Evento toModel(EventoEntity eventoEntity);

}
