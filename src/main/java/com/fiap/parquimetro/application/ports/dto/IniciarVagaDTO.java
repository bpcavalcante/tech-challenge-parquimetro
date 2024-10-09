package com.fiap.parquimetro.application.ports.dto;

import com.fiap.parquimetro.application.controller.dto.EnderecoOutput;
import com.fiap.parquimetro.application.controller.dto.ParquimetroOutput;
import com.fiap.parquimetro.application.controller.dto.VagaOutput;
import com.fiap.parquimetro.domain.Parquimetro;
import com.fiap.parquimetro.domain.Vaga;
import java.time.Instant;
import lombok.Builder;

@Builder
public record IniciarVagaDTO(
    Long id,
    Instant dataHoraInicio,
    String placa,
    Long parquimetro,
    Double parquimetroValorHora,
    String parquimetroNome,
    Long enderecoId,
    String enderecoNumero,
    String enderecoCep,
    String enderecoComplemento) {
  public VagaOutput toOutput() {
    return VagaOutput.builder()
        .id(this.id)
        .dataHoraInicio(this.dataHoraInicio)
        .placa(this.placa)
        .parquimetro(
            ParquimetroOutput.builder()
                .id(this.parquimetro)
                .valorHora(this.parquimetroValorHora)
                .nome(this.parquimetroNome)
                .endereco(
                    EnderecoOutput.builder()
                        .id(this.enderecoId)
                        .numero(this.enderecoNumero)
                        .cep(this.enderecoCep)
                        .complemento(this.enderecoComplemento)
                        .build())
                .build())
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
