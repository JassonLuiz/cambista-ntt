package br.cambista.domains.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Ingresso> ingressos;

    private void criarIngressos(){
        for (int i = 0; i < totalIngressos; i++){
            ingressos.add(new Ingresso(this));
        }
    }

}
