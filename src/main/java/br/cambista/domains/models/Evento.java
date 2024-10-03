package br.cambista.domains.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTeste;
    private String id;
    private String nome;
    private Long totalIngressos;
    private String usuarioCriacao;
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingresso> ingressos;

    @PrePersist
    private void prePersist(){
        this.dataCriacao = LocalDateTime.now();
        criarIngressos();
    }

    private void criarIngressos(){
        if (ingressos == null){
            ingressos = new ArrayList<>();
        }
        for (int i = 0; i < totalIngressos; i++){
            ingressos.add(new Ingresso(this));
        }
    }

    @Override
    public String toString() {
        return "Evento{idTeste=" + idTeste + ", nome='" + nome + "', totalIngressos=" + totalIngressos + "}";
    }

}
