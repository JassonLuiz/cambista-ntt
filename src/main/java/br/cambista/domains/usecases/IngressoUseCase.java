package br.cambista.domains.usecases;

import br.cambista.adapters.integration.entity.ClienteEntity;
import br.cambista.adapters.integration.jpa.IngressoRepository;
import br.cambista.adapters.integration.mapper.IngressoEntityMapper;
import br.cambista.adapters.mapper.IngressoMapper;
import br.cambista.adapters.state.TicketState;
import br.cambista.domains.enumx.IngressoEnum;
import br.cambista.domains.models.Cliente;
import br.cambista.domains.models.Ingresso;
import br.cambista.domains.models.ReservarIngresso;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngressoUseCase {

    private static final Logger log = LoggerFactory.getLogger(IngressoUseCase.class);
    @Autowired
    private IngressoRepository ingressoRepository;

    @Autowired
    private IngressoEntityMapper ingressoEntityMapper;

    public List<Ingresso> reservar(ReservarIngresso reservarIngresso){
        //Verificar se existe quantidade de ingresso disponivel
        Pageable pageable = PageRequest.of(0, reservarIngresso.getQuantidade().intValue());
        var ingressosEntities = ingressoRepository.buscarIngressoPorStatus(
                IngressoEnum.DISPONIVEL.name(),
                reservarIngresso.getIdEvento(),
                pageable);
        if (ingressosEntities.size() < reservarIngresso.getQuantidade()){
            throw new RuntimeException("Essa quantidade de  ingresso não está disponivel.");
        }

        ingressosEntities.forEach(i -> {
            IngressoEnum estadoAtual = i.getStatus();
            TicketState state = estadoAtual.getState();

            String resultado = state.reservar(this.ingressoEntityMapper.toModel(i));
            if(resultado.equals("Ingresso reservado com sucesso.")){
                i.setCliente(ClienteEntity.builder()
                        .id(reservarIngresso.getIdCliente())
                        .build());
                i.setStatus(IngressoEnum.RESERVADO);
                i.setDataCompra(LocalDateTime.now());
            }
        });

        ingressoRepository.saveAll(ingressosEntities);

        return ingressosEntities.stream().map(this.ingressoEntityMapper::toModel).collect(Collectors.toList());
    }

    public List<Ingresso> pagar(List<Long> idsIngressos){
        var ingressosEntities = ingressoRepository.findAllById(idsIngressos);

        ingressosEntities.forEach(ingressoEntity -> {
            IngressoEnum estadoAtual = ingressoEntity.getStatus();

            if (estadoAtual != IngressoEnum.RESERVADO){
                log.error("O ingresso {} não está em estado válido para pagamento. Estado atual: {}", ingressoEntity.getId(), estadoAtual);
                throw new RuntimeException("O ingresso " + ingressoEntity.getId() + " não pode ser pago no estado " + estadoAtual + ".");
            }

            TicketState state = estadoAtual.getState();
            String resultado = state.pagar(ingressoEntityMapper.toModel(ingressoEntity));
            if (resultado.equals("Pagamento realizado com sucesso.")){
                ingressoEntity.setStatus(IngressoEnum.PAGO);
            } else {
                throw new RuntimeException("O ingresso " + ingressoEntity.getId() +  " não pode ser pago no estado atual: " + estadoAtual);
            }
        });

        ingressoRepository.saveAll(ingressosEntities);

        return ingressosEntities.stream().map(ingressoEntityMapper::toModel).collect(Collectors.toList());
    }

    public List<Ingresso> cancelar(List<Long> idsIngressos){
        var ingressosEntities = ingressoRepository.findAllById(idsIngressos);

        ingressosEntities.forEach(ingressoEntity -> {
            IngressoEnum estadoAtual = ingressoEntity.getStatus();
            TicketState state = estadoAtual.getState();

            String resultado = state.cancelar(ingressoEntityMapper.toModel(ingressoEntity));
            if (resultado.equals("Reserva cancelada.") || resultado.equals("Ingresso cancelado e reembolso realizado.")){
                ingressoEntity.setStatus(IngressoEnum.DISPONIVEL);
            } else {
                throw new RuntimeException("O ingresso " + ingressoEntity.getId() +  " não pode ser cancelado no estado atual: " + estadoAtual);
            }
        });

        ingressoRepository.saveAll(ingressosEntities);
        return ingressosEntities.stream().map(ingressoEntityMapper::toModel).collect(Collectors.toList());
    }
}
