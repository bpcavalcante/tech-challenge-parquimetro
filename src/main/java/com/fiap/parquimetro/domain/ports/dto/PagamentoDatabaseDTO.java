package com.fiap.parquimetro.domain.ports.dto;

import com.fiap.parquimetro.application.ports.dto.PagamentoDTO;
import com.fiap.parquimetro.infrastructure.entities.EnderecoEntity;
import com.fiap.parquimetro.infrastructure.entities.VagaEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PagamentoDatabaseDTO {
  Long idPagamento;
  String metodoPagamento;
  BigDecimal valorPagamento;
  Long idVaga;
  Instant vagaDataHoraInicio;
  Instant vagaDataHoraFim;
  Double vagaHorasPermanencia;
  String vagaPlaca;
  private Long parquimetroId;
  private String parquimetroNome;
  private Double parquimetroValorHora;
  private Long enderecoId;
  private String enderecoComplemento;
  private String enderecoCep;
  private String enderecoNumero;

  public PagamentoDTO toPagamentoDto() {
    return PagamentoDTO.builder()
        .idPagamento(this.idPagamento)
        .metodoPagamento(this.metodoPagamento)
        .valorPagamento(this.valorPagamento)
        .idVaga(this.idVaga)
        .vagaDataHoraInicio(this.vagaDataHoraInicio)
        .vagaDataHoraFim(this.vagaDataHoraFim)
        .vagaHorasPermanencia(this.vagaHorasPermanencia)
        .vagaPlaca(this.vagaPlaca)
        .parquimetroId(this.parquimetroId)
        .parquimetroNome(this.parquimetroNome)
        .parquimetroValorHora(this.parquimetroValorHora)
        .enderecoId(this.enderecoId)
        .enderecoComplemento(this.enderecoComplemento)
        .enderecoCep(this.enderecoCep)
        .enderecoNumero(this.enderecoNumero)
        .build();
  }
}
