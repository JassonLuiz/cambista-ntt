package br.cambista.domains.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Evento {

    private Long id;
    private String nome;
    private Long totalIngressos;
    private String usuarioCriacao;
    private LocalDateTime dataCriacao;

    private List<Ingresso> ingressos;


    @Override
    public String toString() {
        return "Evento{id=" + id + ", nome='" + nome + "', totalIngressos=" + totalIngressos + "}";
    }

}
