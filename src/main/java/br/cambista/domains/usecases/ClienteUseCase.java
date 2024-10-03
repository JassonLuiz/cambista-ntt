package br.cambista.domains.usecases;

import br.cambista.adapters.integration.jpa.ClienteRepository;
import br.cambista.adapters.integration.mapper.ClienteEntityMapper;
import br.cambista.domains.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteUseCase {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteEntityMapper entityMapper;

    public Cliente salvar(Cliente cliente){
        return this.entityMapper
                .toModel(repository.save(this.entityMapper.toEntity(cliente)));
    }

    public Cliente buscarPorId(String id){
        return null;
    }
}
