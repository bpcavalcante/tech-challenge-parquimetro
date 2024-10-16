package com.fiap.parquimetro.application.controller.dto.output;

import lombok.Builder;

@Builder
public record ParquimetroOutput(
    Long id,
    String nome,
    Double valorHora,
    EnderecoOutput endereco
) {}
