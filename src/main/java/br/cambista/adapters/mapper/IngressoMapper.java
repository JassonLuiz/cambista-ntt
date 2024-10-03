package br.cambista.adapters.mapper;

import br.cambista.adapters.controller.request.ReservarIngressoRequest;
import br.cambista.adapters.controller.response.IngressoResponse;
import br.cambista.domains.models.Ingresso;
import br.cambista.domains.models.ReservarIngresso;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngressoMapper {

    ReservarIngresso toReservarIngressoModel(ReservarIngressoRequest reservarIngressoRequest);
    IngressoResponse toResponse(Ingresso ingresso);
}
