package com.fiap.parquimetro.application.ports;

import com.fiap.parquimetro.application.ports.dto.PagamentoDTO;

public interface CreatePagamentoUseCasePorts {
  PagamentoDTO criar(PagamentoDTO pagamentoDTO);
}
