package com.fiap.parquimetro.application.controller.dto;

import lombok.Builder;

@Builder
public record EnderecoOutput(
    Long id, String cep, String numero, String complemento) {}
