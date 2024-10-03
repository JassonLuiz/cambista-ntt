package br.cambista.domains.exceptions;

public class AcaoNaoPermitidaException extends RuntimeException{

    public AcaoNaoPermitidaException(String message){
        super(message);
    }
}
