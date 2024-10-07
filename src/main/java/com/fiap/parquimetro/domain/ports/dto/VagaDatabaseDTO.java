package com.fiap.parquimetro.domain.ports.dto;

import com.fiap.parquimetro.application.ports.dto.IniciarVagaDTO;
import com.fiap.parquimetro.domain.Pagamento;
import com.fiap.parquimetro.domain.Parquimetro;
import java.time.Instant;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class VagaDatabaseDTO {
  private Long id;
  private Instant dataHoraInicio;
  private String placa;
  private Long parquimetroId;

  public IniciarVagaDTO toIniciarVagaDTO() {
    return IniciarVagaDTO.builder()
        .id(this.id)
        .dataHoraInicio(this.dataHoraInicio)
        .placa(this.placa)
        .parquimetro(this.parquimetroId)
        .build();
  }
}
