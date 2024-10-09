package com.fiap.parquimetro.application.ports.dto;

import com.fiap.parquimetro.domain.Parquimetro;
import lombok.Builder;

@Builder
public record EnderecoDTO(Long id, String cep, String numero, String complemento, Parquimetro parquimetro) {

}
