package com.fiap.parquimetro.domain.usecase;

import com.fiap.parquimetro.application.ports.CreateParquimetroVagaUseCasePorts;
import com.fiap.parquimetro.application.ports.dto.ParquimetroDTO;
import com.fiap.parquimetro.domain.Parquimetro;
import com.fiap.parquimetro.domain.ports.ParquimetroRepositoryPort;
import com.fiap.parquimetro.domain.ports.dto.ParquimetroDatabaseDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateParquimetroVagaUseCase implements CreateParquimetroVagaUseCasePorts {

  private final ParquimetroRepositoryPort parquimetroRepositoryPort;

  public ParquimetroDTO create(ParquimetroDTO parquimetroDTO) {
    Parquimetro parquimetro = parquimetroDTO.toDomain();
    ParquimetroDatabaseDTO parquimetroDatabaseDTO =
        parquimetroRepositoryPort.save(parquimetro.toDTO());
    return parquimetroDatabaseDTO.toCreateParquimetroDTO();
  }
}
