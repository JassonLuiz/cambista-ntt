package br.cambista.domains.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class Cliente {

    private Long id;
    private String nome;
    private String email;
    private String telefone;

}
