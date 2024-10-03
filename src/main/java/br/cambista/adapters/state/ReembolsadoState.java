package br.cambista.adapters.state;

import br.cambista.domains.models.Ingresso;

public class ReembolsadoState implements TicketState{
    @Override
    public String reservar(Ingresso ingresso) {
        return "Ingresso reembolsado, não pode ser reservado.";
    }

    @Override
    public String pagar(Ingresso ingresso) {
        return "Ingresso reembolsado, não pode ser pago.";
    }

    @Override
    public String cancelar(Ingresso ingresso) {
        return "Ingresso foi reembolsado.";
    }

    @Override
    public String expirar(Ingresso ingresso) {
        return "Ingresso reembolsado, não pode expirar.";
    }
}
