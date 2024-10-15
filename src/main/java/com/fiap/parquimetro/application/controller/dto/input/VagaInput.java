package com.fiap.parquimetro.application.controller.dto.input;

import com.fiap.parquimetro.application.ports.dto.VagaDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record VagaInput(
    @NotBlank String placa, @NotNull Long parquimetroId, String metodoPagamento) {

  public VagaDTO toDto() {
    return VagaDTO.builder()
        .placa(this.placa)
        .parquimetro(this.parquimetroId)
        .metodoPagamento(this.metodoPagamento)
        .build();
  }
}
