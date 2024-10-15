package com.fiap.parquimetro.infrastructure.implementations;

import com.fiap.parquimetro.domain.ports.PagamentoRepositoryPort;
import com.fiap.parquimetro.domain.ports.dto.PagamentoDatabaseDTO;
import com.fiap.parquimetro.infrastructure.PagamentoJpaRepository;
import com.fiap.parquimetro.infrastructure.VagaJpaRepository;
import com.fiap.parquimetro.infrastructure.entities.PagamentoEntity;
import com.fiap.parquimetro.infrastructure.entities.VagaEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;

@RequiredArgsConstructor
public class PagamentoSqlRepositoryImpl implements PagamentoRepositoryPort {
  private final PagamentoJpaRepository pagamentoJpaRepository;
  private final VagaJpaRepository vagaRepository;

  @Override
  @Transactional
  public PagamentoDatabaseDTO save(PagamentoDatabaseDTO pagamentoDatabaseDTO) {
    VagaEntity vaga =
        vagaRepository
            .findById(pagamentoDatabaseDTO.getIdVaga())
            .orElseThrow(() -> new RuntimeException("Vaga nao encontrada"));

    PagamentoEntity newPagamento =
        PagamentoEntity.builder()
            .valor(pagamentoDatabaseDTO.getValorPagamento())
            .metodoPagamento(pagamentoDatabaseDTO.getMetodoPagamento())
            .vaga(vaga)
            .build();

    try {
      return pagamentoJpaRepository.save(newPagamento).toDatabaseDTO();
    } catch (DataAccessException e) {
      throw new RuntimeException("Erro ao criar pagamento", e);
    }
  }
}
