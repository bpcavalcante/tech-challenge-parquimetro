package com.fiap.parquimetro.application.controller.dto.output;

import java.time.Instant;
import lombok.Builder;

@Builder
public record VagaOutput(
    Long id,
    Instant dataHoraInicio,
    Instant dataHoraFim,
    Double horasPermanencia,
    String placa,
    ParquimetroOutput parquimetro,
    boolean isPresentCarro) {}
