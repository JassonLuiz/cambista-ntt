package br.cambista.adapters.integration.mapper;

import br.cambista.adapters.integration.entity.EventoEntity;
import br.cambista.adapters.integration.entity.IngressoEntity;
import br.cambista.domains.models.Evento;
import br.cambista.domains.models.Ingresso;
import org.mapstruct.*;

import java.util.List;
import java.util.Optional;


@Mapper(componentModel = "spring",
        uses = {IngressoEntityMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventoEntityMapper {

    @BeanMapping(builder = @Builder(disableBuilder = true))
    @Mapping(target = "ingressos", qualifiedByName = "ingressoSetToIngressoEntitySet")
    EventoEntity toEntity(Evento evento);

    @IterableMapping(qualifiedByName = "ingressoToIngressoEntity")
    @Named("ingressoSetToIngressoEntitySet")
    List<IngressoEntity> ingressoSetToIngressoEntitySet(List<Ingresso> list);

    @Named("ingressoToIngressoEntity")
    IngressoEntity ingressoToIngressoEntity(Ingresso model);

    @AfterMapping
    default void setEvento(@MappingTarget EventoEntity entity) {
        Optional.ofNullable(entity.getIngressos())
                .ifPresent(it -> it.forEach(d -> d.setEvento(entity)));
    }

    Evento toModel(EventoEntity eventoEntity);

}
