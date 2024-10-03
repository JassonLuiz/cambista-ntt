package br.cambista.adapters.mapper;

import br.cambista.adapters.controller.request.ClienteRequest;
import br.cambista.adapters.controller.response.ClienteResponse;
import br.cambista.domains.models.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toModel(ClienteRequest clienteRequest);

    ClienteResponse toResponse(Cliente cliente);
}
