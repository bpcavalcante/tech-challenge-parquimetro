package com.fiap.parquimetro.application.ports;

import com.fiap.parquimetro.application.ports.dto.VagaDTO;

public interface EncerrarVagaUseCasePorts {
  VagaDTO encerrarVaga(VagaDTO iniciarVagaDTO);
}
