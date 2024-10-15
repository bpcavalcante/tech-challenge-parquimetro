package com.fiap.parquimetro.domain;

import com.fiap.parquimetro.domain.ports.dto.PagamentoDatabaseDTO;
import java.math.BigDecimal;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pagamento {

  private Long id;
  private BigDecimal valor;
  private String metodoPagamento;
  private Vaga vaga;

  public PagamentoDatabaseDTO toDTO() {
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
        .enderecoNumero(this.vaga.getParquimetro().getEndereco().getNumero())
        .enderecoCep(this.vaga.getParquimetro().getEndereco().getCep())
        .enderecoComplemento(this.vaga.getParquimetro().getEndereco().getComplemento())
        .build();
  }
}
