package com.fiap.parquimetro.application.controller.dto;

import com.fiap.parquimetro.application.ports.dto.ParquimetroDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record ParquimetroInput(
    @NotBlank String complementoEndereco,
    // TODO : Validar caracteres especiais
    @NotBlank String cepEndereco,
    Double valorHoraParquimetro,
    @NotBlank String nomeParquimetro,
    @NotBlank String numero) {

  public ParquimetroDTO toDto() {
    return ParquimetroDTO.builder()
        .nome(this.nomeParquimetro)
        .valorHora(this.valorHoraParquimetro)
        .complemento(this.complementoEndereco)
        .cep(this.cepEndereco)
        .numero(this.numero)
        .build();
  }
}
