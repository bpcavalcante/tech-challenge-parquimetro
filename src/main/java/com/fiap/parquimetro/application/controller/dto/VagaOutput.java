package com.fiap.parquimetro.application.controller.dto;

import com.fiap.parquimetro.infrastructure.entities.ParquimetroEntity;
import java.time.Instant;
import lombok.Builder;

@Builder
public record VagaOutput(
    Long id,
    Instant dataHoraInicio,
    String placa,
    ParquimetroOutput parquimetro) {}
