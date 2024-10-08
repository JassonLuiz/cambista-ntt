package br.cambista.adapters.integration.entity;

import br.cambista.domains.models.Ingresso;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"ingressos"})
@EqualsAndHashCode(exclude = {"ingressos"})
@Entity
@Table(name = "eventos")
public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Long totalIngressos;
    private String usuarioCriacao;
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<IngressoEntity> ingressos;

    @Override
    public String toString() {
        return "Evento{id=" + id + ", nome='" + nome + "', totalIngressos=" + totalIngressos + "}";
    }
}
