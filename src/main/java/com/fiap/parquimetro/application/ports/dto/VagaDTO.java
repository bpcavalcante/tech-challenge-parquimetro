package com.fiap.parquimetro.application.ports.dto;

import com.fiap.parquimetro.application.controller.dto.output.EnderecoOutput;
import com.fiap.parquimetro.application.controller.dto.output.ParquimetroOutput;
import com.fiap.parquimetro.application.controller.dto.output.VagaOutput;
import com.fiap.parquimetro.domain.Parquimetro;
import com.fiap.parquimetro.domain.Vaga;
import java.time.Instant;
import lombok.Builder;

@Builder
public record VagaDTO(
    Long id,
    Instant dataHoraInicio,
    Instant dataHoraFim,
    Double horasPermanencia,
    String placa,
    Long parquimetro,
    Double parquimetroValorHora,
    String parquimetroNome,
    Long enderecoId,
    String enderecoNumero,
    String enderecoCep,
    String enderecoComplemento,
    boolean isPresentCarro,
    String metodoPagamento) {

  public VagaOutput toOutput() {
    return VagaOutput.builder()
        .id(this.id)
        .dataHoraInicio(this.dataHoraInicio)
        .dataHoraFim(this.dataHoraFim)
        .horasPermanencia(this.horasPermanencia)
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
        .isPresentCarro(this.isPresentCarro)
        .build();
  }

  public Vaga toDomain() {
    return Vaga.builder()
        .dataHoraInicio(this.dataHoraInicio)
        .placa(this.placa)
        .parquimetro(
            Parquimetro.builder()
                .id(this.parquimetro)
                .valorHora(this.parquimetroValorHora)
                .nome(this.parquimetroNome)
                .build())
        .build();
  }
}
