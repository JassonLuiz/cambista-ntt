package br.cambista.adapters.state;

import br.cambista.domains.models.Ingresso;

public class PagoState implements TicketState {

    @Override
    public String reservar(Ingresso ingresso) {
        return "Ingresso já pago, não é possivel reservar.";
    }

    @Override
    public String pagar(Ingresso ingresso) {
        return "Ingresso já foi pago.";
    }

    @Override
    public String cancelar(Ingresso ingresso) {
        ingresso.setState(new ReembolsadoState());
        return "Ingresso cancelado e reembolso realizado.";
    }

    @Override
    public String expirar(Ingresso ingresso) {
        return "Ingresso já foi pago, não pode expirar.";
    }
}
