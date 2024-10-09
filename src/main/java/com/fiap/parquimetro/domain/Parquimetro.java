package com.fiap.parquimetro.domain;

import com.fiap.parquimetro.domain.ports.dto.ParquimetroDatabaseDTO;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Parquimetro {

  private Long id;
  private Double valorHora;
  private String nome;
  private Endereco endereco;

  public ParquimetroDatabaseDTO toDTO() {
    return ParquimetroDatabaseDTO.builder()
        .id(this.id)
        .nome(this.nome)
        .valorHora(this.valorHora)
        .cep(this.endereco.getCep())
        .complemento(this.endereco.getComplemento())
        .numero(this.endereco.getNumero())
        .build();
  }
}
