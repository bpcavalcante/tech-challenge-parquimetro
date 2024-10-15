package com.fiap.parquimetro.infrastructure.entities;

import com.fiap.parquimetro.domain.ports.dto.PagamentoDatabaseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_pagamento")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PagamentoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private BigDecimal valor;
  private String metodoPagamento;
  @OneToOne private VagaEntity vaga;

  public PagamentoDatabaseDTO toDatabaseDTO() {
    return PagamentoDatabaseDTO.builder()
        .idPagamento(this.id)
        .valorPagamento(this.valor)
        .metodoPagamento(this.metodoPagamento)
        .idVaga(this.vaga.getId())
        .vagaDataHoraInicio(this.vaga.getDataHoraInicio())
        .vagaDataHoraFim(this.vaga.getDataHoraFim())
        .vagaHorasPermanencia(this.vaga.getTempoPermanencia())
        .vagaPlaca(this.vaga.getPlaca())
        .parquimetroId(this.vaga.getParquimetro().getId())
        .parquimetroNome(this.vaga.getParquimetro().getNome())
        .parquimetroValorHora(this.vaga.getParquimetro().getValorHora())
        .enderecoId(this.vaga.getParquimetro().getEndereco().getId())
        .enderecoCep(this.vaga.getParquimetro().getEndereco().getCep())
        .enderecoNumero(this.vaga.getParquimetro().getEndereco().getNumero())
        .enderecoComplemento(this.vaga.getParquimetro().getEndereco().getComplemento())
        .build();
  }
}
