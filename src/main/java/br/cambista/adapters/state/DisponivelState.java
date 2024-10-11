package br.cambista.adapters.state;

import br.cambista.domains.exceptions.AcaoNaoPermitidaException;
import br.cambista.domains.models.Ingresso;

public class DisponivelState implements TicketState{


    @Override
    public String reservar(Ingresso ingresso) {
        return "Ingresso reservado com sucesso.";
    }

    @Override
    public String pagar(Ingresso ingresso) {
        return "Pagamento não permitido no estado Disponível. Reserve o ingresso primeiro.";
    }

    @Override
    public String cancelar(Ingresso ingresso) {
        return "Não há ingresso para cancelar.";
    }

    @Override
    public String expirar(Ingresso ingresso) {
        return "Ingresso ainda está disponível.";
    }
}
