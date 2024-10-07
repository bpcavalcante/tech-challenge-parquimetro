package com.fiap.parquimetro.domain.ports;

import com.fiap.parquimetro.domain.ports.dto.VagaDatabaseDTO;

public interface VagaRepositoryPort {
  VagaDatabaseDTO save(VagaDatabaseDTO vagaDatabaseDTO);
}
