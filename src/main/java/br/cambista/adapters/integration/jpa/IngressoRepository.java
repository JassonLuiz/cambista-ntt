package br.cambista.adapters.integration.jpa;

import br.cambista.adapters.integration.entity.IngressoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IngressoRepository extends JpaRepository<IngressoEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT i FROM IngressoEntity i " +
            " WHERE i.status = :status " +
            " AND i.evento.id = :idEvento " +
            " LIMIT :quantidade ")
    List<IngressoEntity> buscarIngressoPorStatus(@Param("status") String status,
                                                 @Param("quantidade") Long quantidade,
                                                 @Param("idEvento") Long idEvento);
}
