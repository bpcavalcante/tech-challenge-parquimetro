package com.fiap.parquimetro.domain;

import com.fiap.parquimetro.domain.ports.dto.VagaDatabaseDTO;
import java.math.BigDecimal;
import java.time.Instant;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vaga {

  private Long id;
  private Instant dataHoraInicio;
  private Instant dataHoraFim;
  private Double tempoPermanencia;
  private String placa;
  private Parquimetro parquimetro;
  private Pagamento pagamento;
  private boolean isPresentCarro;

  public VagaDatabaseDTO toDTO() {
    return VagaDatabaseDTO.builder()
        .id(this.id)
        .dataHoraInicio(this.dataHoraInicio)
        .dataHoraFim(this.dataHoraFim)
        .horasPermanencia(this.tempoPermanencia)
        .placa(this.placa)
        .parquimetroId(this.parquimetro != null ? this.parquimetro.getId() : null)
        .isPresentCarro(this.isPresentCarro)
        .metodoPagamento(
            this.pagamento != null && !this.pagamento.getMetodoPagamento().isBlank()
                ? this.pagamento.getMetodoPagamento()
                : "")
        .valorPagamento(
            this.pagamento != null && this.pagamento.getValor() != null
                ? this.pagamento.getValor()
                : BigDecimal.ZERO)
        .build();
  }
}
