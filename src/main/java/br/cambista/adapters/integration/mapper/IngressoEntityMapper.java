package br.cambista.adapters.integration.mapper;

import br.cambista.adapters.integration.entity.IngressoEntity;
import br.cambista.domains.models.Ingresso;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngressoEntityMapper {

    IngressoEntity toEntity(Ingresso ingresso);

    Ingresso toModel(IngressoEntity ingressoEntity);
}
