package com.fiap.parquimetro.domain.usecase;

import com.fiap.parquimetro.application.ports.EncerrarVagaUseCasePorts;
import com.fiap.parquimetro.application.ports.dto.VagaDTO;
import com.fiap.parquimetro.domain.Pagamento;
import com.fiap.parquimetro.domain.Vaga;
import com.fiap.parquimetro.domain.ports.VagaRepositoryPort;
import com.fiap.parquimetro.domain.ports.dto.VagaDatabaseDTO;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EncerrarVagaUseCase implements EncerrarVagaUseCasePorts {
  private final VagaRepositoryPort vagaRepositoryPort;

  @Override
  public VagaDTO encerrarVaga(VagaDTO iniciarVagaDTO) {
    Vaga vaga = iniciarVagaDTO.toDomain();
    Vaga vagaAtual =
        vagaRepositoryPort
            .findByParquimetroIdAndPlacaAndIsPresentCarroTrue(iniciarVagaDTO.toDomain().toDTO())
            .toIniciarVagaDTO()
            .toDomain();

    vaga.setDataHoraFim(Instant.now());
    vaga.setTempoPermanencia(
        (double) Duration.between(vagaAtual.getDataHoraInicio(), vaga.getDataHoraFim()).toHours());

    Pagamento novoPagamento =
        Pagamento.builder()
            .metodoPagamento(iniciarVagaDTO.metodoPagamento())
            .valor(
                getValorPagamento(vaga.getTempoPermanencia(), vagaAtual.getParquimetro().getValorHora()))
            .build();

    vaga.setPagamento(novoPagamento);

    VagaDatabaseDTO vagaDatabaseDTO = vagaRepositoryPort.close(vaga.toDTO());
    return vagaDatabaseDTO.toIniciarVagaDTO();
  }

  private BigDecimal getValorPagamento(Double horas, Double valorHora) {
    if (valorHora >= 1) {
      return BigDecimal.valueOf(valorHora * horas);
    } else {
      return BigDecimal.valueOf(valorHora * 1);
    }
  }
}
