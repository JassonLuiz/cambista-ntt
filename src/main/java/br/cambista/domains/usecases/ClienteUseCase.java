package br.cambista.domains.usecases;

import br.cambista.domains.models.Cliente;
import br.cambista.domains.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteUseCase {

    @Autowired
    ClienteRepository repository;

    public Cliente salvar(Cliente cliente){
        return repository.save(cliente);
    }

    public Cliente buscarPorId(String id){
        return null;
    }
}
