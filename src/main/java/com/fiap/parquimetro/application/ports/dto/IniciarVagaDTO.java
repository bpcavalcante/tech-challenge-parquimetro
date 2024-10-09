package com.fiap.parquimetro.application.ports.dto;

import com.fiap.parquimetro.application.controller.dto.VagaOutput;
import com.fiap.parquimetro.domain.Parquimetro;
import com.fiap.parquimetro.domain.Vaga;
import com.fiap.parquimetro.infrastructure.entities.ParquimetroEntity;
import java.time.Instant;
import lombok.Builder;

@Builder
public record IniciarVagaDTO(Long id, Instant dataHoraInicio, String placa, Long parquimetro, Double parquimetroValorHora) {
  public VagaOutput toOutput() {
    return VagaOutput.builder()
        .id(this.id)
        .dataHoraInicio(this.dataHoraInicio)
        .placa(this.placa)
        .parquimetro(ParquimetroEntity.builder().id(this.parquimetro).build())
        .parquimetro(ParquimetroEntity.builder().valorHora(this.parquimetroValorHora).build())
        .build();
  }

  public Vaga toDomain() {
    return Vaga.builder()
        .dataHoraInicio(this.dataHoraInicio)
        .placa(this.placa)
        .parquimetro(Parquimetro.builder().id(this.parquimetro).build())
        .build();
  }
}
