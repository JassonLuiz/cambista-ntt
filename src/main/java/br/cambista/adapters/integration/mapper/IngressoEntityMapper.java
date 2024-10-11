package br.cambista.adapters.integration.mapper;

import br.cambista.adapters.integration.entity.EventoEntity;
import br.cambista.adapters.integration.entity.IngressoEntity;
import br.cambista.domains.models.Ingresso;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IngressoEntityMapper {

    IngressoEntity toEntity(Ingresso ingresso);

    @Mapping(target = "nomeEvento", source = "evento.nome")
    Ingresso toModel(IngressoEntity ingressoEntity);
}
