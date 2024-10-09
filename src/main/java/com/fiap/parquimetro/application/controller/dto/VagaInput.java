package com.fiap.parquimetro.application.controller.dto;

import com.fiap.parquimetro.application.ports.dto.IniciarVagaDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.springframework.format.annotation.NumberFormat;

import java.time.Instant;

@Builder
public record VagaInput(@NotBlank String placa, Long parquimetroId) {
  public IniciarVagaDTO toDto() {
    return IniciarVagaDTO.builder().placa(this.placa).parquimetro(this.parquimetroId).build();
  }
}
