package com.fiap.parquimetro.application.ports.dto;

import com.fiap.parquimetro.application.controller.dto.output.EnderecoOutput;
import com.fiap.parquimetro.application.controller.dto.output.PagamentoOutput;
import com.fiap.parquimetro.application.controller.dto.output.ParquimetroOutput;
import com.fiap.parquimetro.application.controller.dto.output.VagaOutput;
import com.fiap.parquimetro.domain.Endereco;
import com.fiap.parquimetro.domain.Pagamento;
import com.fiap.parquimetro.domain.Parquimetro;
import com.fiap.parquimetro.domain.Vaga;
import java.math.BigDecimal;
import java.time.Instant;
import lombok.Builder;

@Builder
public record PagamentoDTO(
    Long idPagamento,
    String metodoPagamento,
    BigDecimal valorPagamento,
    Long idVaga,
    Instant vagaDataHoraInicio,
    Instant vagaDataHoraFim,
    Double vagaHorasPermanencia,
    String vagaPlaca,
    Long parquimetroId,
    String parquimetroNome,
    Double parquimetroValorHora,
    Long enderecoId,
    String enderecoComplemento,
    String enderecoCep,
    String enderecoNumero) {

  public PagamentoOutput toOutput() {
    return PagamentoOutput.builder()
        .id(this.idPagamento)
        .metodoPagamento(this.metodoPagamento)
        .valor(this.valorPagamento)
        .vaga(
            VagaOutput.builder()
                .id(this.idVaga)
                .dataHoraInicio(this.vagaDataHoraInicio)
                .dataHoraFim(this.vagaDataHoraFim)
                .horasPermanencia(this.vagaHorasPermanencia)
                .placa(this.vagaPlaca)
                .parquimetro(
                    ParquimetroOutput.builder()
                        .id(this.parquimetroId)
                        .nome(this.parquimetroNome)
                        .valorHora(this.parquimetroValorHora)
                        .endereco(
                            EnderecoOutput.builder()
                                .id(this.enderecoId)
                                .cep(enderecoCep)
                                .complemento(enderecoComplemento)
                                .numero(enderecoNumero)
                                .build())
                        .build())
                .build())
        .build();
  }

  public Pagamento toDomain() {
    return Pagamento.builder()
        .id(this.idPagamento)
        .metodoPagamento(this.metodoPagamento)
        .valor(this.valorPagamento)
        .vaga(
            Vaga.builder()
                .id(this.idVaga)
                .dataHoraInicio(this.vagaDataHoraInicio)
                .dataHoraFim(this.vagaDataHoraFim)
                .tempoPermanencia(this.vagaHorasPermanencia)
                .placa(this.vagaPlaca)
                .parquimetro(
                    Parquimetro.builder()
                        .id(this.parquimetroId)
                        .nome(this.parquimetroNome)
                        .valorHora(this.parquimetroValorHora)
                        .endereco(
                            Endereco.builder()
                                .cep(enderecoCep)
                                .complemento(enderecoComplemento)
                                .numero(enderecoNumero)
                                .build())
                        .build())
                .build())
        .build();
  }
}
