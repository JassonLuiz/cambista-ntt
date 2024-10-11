package br.cambista.domains.enumx;

import br.cambista.adapters.state.*;

public enum IngressoEnum {

    DISPONIVEL {
        @Override
        public TicketState getState() {
            return new DisponivelState();
        }
    },
    RESERVADO {
        @Override
        public TicketState getState() {
            return new ReservadoState();
        }
    },
    PAGO {
        @Override
        public TicketState getState() {
            return new PagoState();
        }
    },
    REEMBOLSADO {
        @Override
        public TicketState getState() {
            return new ReembolsadoState();
        }
    };

    public abstract TicketState getState();
}
