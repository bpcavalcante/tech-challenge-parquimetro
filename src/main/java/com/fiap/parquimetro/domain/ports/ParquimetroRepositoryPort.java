package com.fiap.parquimetro.domain.ports;

import com.fiap.parquimetro.domain.ports.dto.ParquimetroDatabaseDTO;

public interface ParquimetroRepositoryPort {
  ParquimetroDatabaseDTO save(ParquimetroDatabaseDTO parquimetroDatabaseDTO);
}
