package br.cambista.adapters.integration.jpa;

import br.cambista.adapters.integration.entity.EventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<EventoEntity, Long> {
}
