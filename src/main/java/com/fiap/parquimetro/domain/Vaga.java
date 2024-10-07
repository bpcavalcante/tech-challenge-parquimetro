package com.fiap.parquimetro.domain;

import com.fiap.parquimetro.application.ports.dto.IniciarVagaDTO;
import com.fiap.parquimetro.domain.ports.dto.VagaDatabaseDTO;
import com.fiap.parquimetro.infrastructure.entities.PagamentoEntity;
import com.fiap.parquimetro.infrastructure.entities.ParquimetroEntity;
import jakarta.persistence.*;
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

  public VagaDatabaseDTO toDTO() {
    return VagaDatabaseDTO.builder()
        .id(this.id)
        .dataHoraInicio(this.dataHoraInicio)
        .placa(this.placa)
        .parquimetroId(this.parquimetro.getId())
        .build();
  }
}
