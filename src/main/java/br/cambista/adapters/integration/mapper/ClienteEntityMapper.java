package br.cambista.adapters.integration.mapper;

import br.cambista.adapters.integration.entity.ClienteEntity;
import br.cambista.domains.models.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {

    ClienteEntity toEntity(Cliente cliente);

    Cliente toModel(ClienteEntity clienteEntity);
}
