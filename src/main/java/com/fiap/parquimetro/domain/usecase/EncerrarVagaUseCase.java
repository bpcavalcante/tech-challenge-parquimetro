package com.fiap.parquimetro.domain.usecase;

import com.fiap.parquimetro.application.ports.EncerrarVagaUseCasePorts;
import com.fiap.parquimetro.application.ports.dto.VagaDTO;
import com.fiap.parquimetro.domain.Vaga;
import com.fiap.parquimetro.domain.ports.VagaRepositoryPort;
import com.fiap.parquimetro.domain.ports.dto.VagaDatabaseDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EncerrarVagaUseCase implements EncerrarVagaUseCasePorts {
  private final VagaRepositoryPort vagaRepositoryPort;

  @Override
  public VagaDTO encerrarVaga(VagaDTO iniciarVagaDTO) {
    Vaga vaga = iniciarVagaDTO.toDomain();
    VagaDatabaseDTO vagaDatabaseDTO = vagaRepositoryPort.close(vaga.toDTO());
    return vagaDatabaseDTO.toIniciarVagaDTO();
  }
}
