package com.fiap.parquimetro.application.ports.dto;

import com.fiap.parquimetro.application.controller.dto.output.EnderecoOutput;
import com.fiap.parquimetro.application.controller.dto.output.ParquimetroOutput;
import com.fiap.parquimetro.domain.Endereco;
import com.fiap.parquimetro.domain.Parquimetro;
import lombok.Builder;

@Builder
public record ParquimetroDTO(
    Long id, String nome, Double valorHora, Long enderecoId, String complemento, String cep, String numero) {
  public ParquimetroOutput toOutput() {
    return ParquimetroOutput.builder()
        .id(this.id)
        .nome(this.nome)
        .valorHora(this.valorHora)
        .endereco(EnderecoOutput.builder().id(this.enderecoId).cep(cep).complemento(complemento).numero(numero).build())
        .build();
  }

  public Parquimetro toDomain() {
    return Parquimetro.builder()
        .id(this.id)
        .nome(this.nome)
        .valorHora(this.valorHora)
        .endereco(Endereco.builder().cep(cep).complemento(complemento).numero(numero).build())
        .build();
  }
}
