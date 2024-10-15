package com.fiap.parquimetro.domain.usecase;

import com.fiap.parquimetro.application.ports.CreatePagamentoUseCasePorts;
import com.fiap.parquimetro.application.ports.dto.PagamentoDTO;
import com.fiap.parquimetro.domain.Pagamento;
import com.fiap.parquimetro.domain.ports.PagamentoRepositoryPort;
import com.fiap.parquimetro.domain.ports.dto.PagamentoDatabaseDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreatePagamentoUseCase implements CreatePagamentoUseCasePorts {

  private final PagamentoRepositoryPort pagamentoRepositoryPort;

  @Override
  public PagamentoDTO criar(PagamentoDTO pagamentoDTO) {
    Pagamento pagamento = pagamentoDTO.toDomain();
    PagamentoDatabaseDTO pagamentoDatabaseDTO = pagamentoRepositoryPort.save(pagamento.toDTO());
    return pagamentoDatabaseDTO.toPagamentoDto();
  }
}
