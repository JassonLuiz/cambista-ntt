package br.cambista.adapters.state;

import br.cambista.domains.models.Ingresso;

public class ReservadoState implements TicketState{

    @Override
    public String reservar(Ingresso ingresso) {
        return "Ingresso já está reservado.";
    }

    @Override
    public String pagar(Ingresso ingresso) {
        //ingresso.setState(new PagoState());
        return "Pagamento realizado com sucesso.";
    }

    @Override
    public String cancelar(Ingresso ingresso) {
        //ingresso.setState(new DisponivelState());
        return "Reserva cancelada.";
    }

    @Override
    public String expirar(Ingresso ingresso) {
        //ingresso.setState(new DisponivelState());
        return "Reserva expirada.";
    }
}
