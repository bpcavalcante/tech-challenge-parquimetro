package com.fiap.parquimetro.application.ports;

import com.fiap.parquimetro.application.ports.dto.VagaDTO;

public interface CreateIniciarVagaUseCasePorts {
  VagaDTO iniciarVaga(VagaDTO iniciarVagaDTO);
}
