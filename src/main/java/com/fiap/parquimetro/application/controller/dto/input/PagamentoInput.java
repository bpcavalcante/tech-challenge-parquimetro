package com.fiap.parquimetro.application.controller.dto.input;

import com.fiap.parquimetro.application.ports.dto.PagamentoDTO;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Builder;

@Builder
public record PagamentoInput(@NotBlank String metodoPagamento, @NotNull BigDecimal valor, @NotNull Long idVaga) {
  public PagamentoDTO pagamentoInputToDTO() {
    return PagamentoDTO.builder()
        .metodoPagamento(this.metodoPagamento)
        .valorPagamento(this.valor)
        .idVaga(this.idVaga)
        .build();
  }
}
