package com.fiap.parquimetro.application.ports;

import com.fiap.parquimetro.application.ports.dto.ParquimetroDTO;

public interface CreateParquimetroVagaUseCasePorts {
  ParquimetroDTO create (ParquimetroDTO parquimetroDTO);
}
