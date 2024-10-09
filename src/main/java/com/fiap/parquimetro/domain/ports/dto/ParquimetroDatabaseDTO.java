package com.fiap.parquimetro.domain.ports.dto;

import com.fiap.parquimetro.application.ports.dto.ParquimetroDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ParquimetroDatabaseDTO {
  private Long id;
  private String nome;
  private Double valorHora;
  private Long enderecoId;
  private String complemento;
  private String cep;
  private String numero;

  public ParquimetroDTO toCreateParquimetroDTO() {
    return ParquimetroDTO.builder()
        .id(this.id)
        .nome(this.nome)
        .valorHora(this.valorHora)
        .enderecoId(enderecoId)
        .cep(this.cep)
        .complemento(this.complemento)
        .numero(this.numero)
        .build();
  }
}
