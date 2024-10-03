package br.cambista.domains.usecases;

import br.cambista.adapters.integration.entity.ClienteEntity;
import br.cambista.adapters.integration.jpa.IngressoRepository;
import br.cambista.adapters.integration.mapper.IngressoEntityMapper;
import br.cambista.adapters.mapper.IngressoMapper;
import br.cambista.domains.enumx.IngressoEnum;
import br.cambista.domains.models.Cliente;
import br.cambista.domains.models.Ingresso;
import br.cambista.domains.models.ReservarIngresso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngressoUseCase {

    @Autowired
    private IngressoRepository ingressoRepository;

    @Autowired
    private IngressoEntityMapper ingressoEntityMapper;

    public List<Ingresso> reservar(ReservarIngresso reservarIngresso){
        //Verificar se existe quantidade de ingresso disponivel
        var ingressosEntities = ingressoRepository.buscarIngressoPorStatus(
                IngressoEnum.DISPONIVEL.toString(),
                reservarIngresso.getQuantidade(),
                reservarIngresso.getIdEvento());
        if (ingressosEntities.size() < reservarIngresso.getQuantidade()){
            //Lançar exceção
        }

        ingressosEntities.forEach(i -> {
            i.setCliente(ClienteEntity.builder()
                    .id(reservarIngresso.getIdCliente())
                    .build());
        });
        //Atualizar o status do ingresso
        //Atribuir os ingressosEntities ao cliente
        return ingressosEntities.stream().map(this.ingressoEntityMapper::toModel).collect(Collectors.toList());
    }
}
