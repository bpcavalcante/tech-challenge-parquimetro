package com.fiap.parquimetro.domain.usecase;

import com.fiap.parquimetro.application.ports.CreateIniciarVagaUseCasePorts;
import com.fiap.parquimetro.application.ports.dto.VagaDTO;
import com.fiap.parquimetro.domain.Vaga;
import com.fiap.parquimetro.domain.ports.VagaRepositoryPort;
import com.fiap.parquimetro.domain.ports.dto.VagaDatabaseDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateIniciarVagaUseCase implements CreateIniciarVagaUseCasePorts {

  private final VagaRepositoryPort vagaRepositoryPort;

  public VagaDTO iniciarVaga(VagaDTO iniciarVagaDTO) {
    Vaga vaga = iniciarVagaDTO.toDomain();
    VagaDatabaseDTO vagaDatabaseDTO = vagaRepositoryPort.create(vaga.toDTO());
    return vagaDatabaseDTO.toIniciarVagaDTO();
  }
}
