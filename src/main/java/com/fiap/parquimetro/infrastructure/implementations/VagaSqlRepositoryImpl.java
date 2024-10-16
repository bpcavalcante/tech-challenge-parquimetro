package com.fiap.parquimetro.infrastructure.implementations;

import com.fiap.parquimetro.domain.ports.VagaRepositoryPort;
import com.fiap.parquimetro.domain.ports.dto.VagaDatabaseDTO;
import com.fiap.parquimetro.infrastructure.ParquimetroJpaRepository;
import com.fiap.parquimetro.infrastructure.VagaJpaRepository;
import com.fiap.parquimetro.infrastructure.entities.PagamentoEntity;
import com.fiap.parquimetro.infrastructure.entities.ParquimetroEntity;
import com.fiap.parquimetro.infrastructure.entities.VagaEntity;
import jakarta.transaction.Transactional;
import java.time.Duration;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;

@RequiredArgsConstructor
public class VagaSqlRepositoryImpl implements VagaRepositoryPort {
  private final VagaJpaRepository vagaRepository;
  private final ParquimetroJpaRepository parquimetroRepository;


  @Override
  public VagaDatabaseDTO findByParquimetroIdAndPlacaAndIsPresentCarroTrue(VagaDatabaseDTO vagaDatabaseDTO) {
    VagaEntity vaga = vagaRepository.findByParquimetroIdAndPlacaAndIsPresentCarroTrue(vagaDatabaseDTO.getParquimetroId(), vagaDatabaseDTO.getPlaca())
        .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));

    return vaga.toDatabaseDTO();
  }

  @Override
  @Transactional
  public VagaDatabaseDTO create(VagaDatabaseDTO vagaDatabaseDTO) {
    ParquimetroEntity parquimetro =
        parquimetroRepository
            .findById(vagaDatabaseDTO.getParquimetroId())
            .orElseThrow(() -> new RuntimeException("Parquimetro não encontrado"));

    VagaEntity newVaga =
        VagaEntity.builder()
            .id(vagaDatabaseDTO.getId())
            .placa(vagaDatabaseDTO.getPlaca())
            .dataHoraInicio(Instant.now())
            .parquimetro(parquimetro)
            .isPresentCarro(true)
            .build();

    try {
      return vagaRepository.save(newVaga).toDatabaseDTO();
    } catch (DataAccessException e) {
      throw new RuntimeException("Erro ao criar vaga", e);
    }
  }

  @Override
  @Transactional(Transactional.TxType.REQUIRED)
  public VagaDatabaseDTO close(VagaDatabaseDTO vagaDatabaseDTO) {
     VagaEntity vaga = vagaRepository.findByParquimetroIdAndPlacaAndIsPresentCarroTrue(vagaDatabaseDTO.getParquimetroId(), vagaDatabaseDTO.getPlaca())
         .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));

    PagamentoEntity newPagamento =
        PagamentoEntity.builder()
            .valor(vagaDatabaseDTO.getValorPagamento())
            .metodoPagamento(vagaDatabaseDTO.getMetodoPagamento())
            .vaga(vaga)
            .build();

     vaga.setDataHoraFim(vagaDatabaseDTO.getDataHoraFim());
     vaga.setTempoPermanencia(vagaDatabaseDTO.getHorasPermanencia());
     vaga.setPagamento(newPagamento);
     vaga.setPresentCarro(false);

    try {
      return vagaRepository.save(vaga).toDatabaseDTO();
    } catch (DataAccessException e) {
      throw new RuntimeException("Erro ao criar vaga", e);
    }
  }
}
