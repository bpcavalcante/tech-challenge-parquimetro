package com.fiap.parquimetro.application.controller.dto.output;

import java.math.BigDecimal;
import lombok.Builder;

@Builder
public record PagamentoOutput(
    Long id,
    String metodoPagamento,
    BigDecimal valor,
    VagaOutput vaga
) {}
