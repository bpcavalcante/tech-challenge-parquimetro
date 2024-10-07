package com.fiap.parquimetro.domain.usecase;

import com.fiap.parquimetro.application.ports.CreateIniciarVagaUseCasePorts;
import com.fiap.parquimetro.application.ports.dto.IniciarVagaDTO;
import com.fiap.parquimetro.domain.Vaga;
import com.fiap.parquimetro.domain.ports.VagaRepositoryPort;
import com.fiap.parquimetro.domain.ports.dto.VagaDatabaseDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateIniciarVagaUseCase implements CreateIniciarVagaUseCasePorts {

  private final VagaRepositoryPort vagaRepositoryPort;

  public IniciarVagaDTO iniciarVaga(IniciarVagaDTO iniciarVagaDTO) {
    Vaga vaga = iniciarVagaDTO.toDomain();
    VagaDatabaseDTO vagaDatabaseDTO = vagaRepositoryPort.save(vaga.toDTO());
    return vagaDatabaseDTO.toIniciarVagaDTO();
  }
}
