package com.fiap.parquimetro.domain.ports;

import com.fiap.parquimetro.domain.ports.dto.PagamentoDatabaseDTO;

public interface PagamentoRepositoryPort {
  PagamentoDatabaseDTO save(PagamentoDatabaseDTO pagamentoDatabaseDTO);
}
