package com.fiap.parquimetro.domain.ports;

import com.fiap.parquimetro.domain.ports.dto.VagaDatabaseDTO;

public interface VagaRepositoryPort {
  VagaDatabaseDTO findByParquimetroIdAndPlacaAndIsPresentCarroTrue(VagaDatabaseDTO vagaDatabaseDTO);
  VagaDatabaseDTO create(VagaDatabaseDTO vagaDatabaseDTO);
  VagaDatabaseDTO close(VagaDatabaseDTO vagaDatabaseDTO);
}
