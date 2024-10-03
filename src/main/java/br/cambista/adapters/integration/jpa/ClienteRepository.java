package br.cambista.adapters.integration.jpa;

import br.cambista.adapters.integration.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
