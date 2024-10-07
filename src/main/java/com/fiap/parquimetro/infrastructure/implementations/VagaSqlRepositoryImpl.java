package com.fiap.parquimetro.infrastructure.implementations;

import com.fiap.parquimetro.domain.ports.VagaRepositoryPort;
import com.fiap.parquimetro.domain.ports.dto.VagaDatabaseDTO;
import com.fiap.parquimetro.infrastructure.ParquimetroJpaRepository;
import com.fiap.parquimetro.infrastructure.VagaJpaRepository;
import com.fiap.parquimetro.infrastructure.entities.ParquimetroEntity;
import com.fiap.parquimetro.infrastructure.entities.VagaEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;

@RequiredArgsConstructor
public class VagaSqlRepositoryImpl implements VagaRepositoryPort {
  private final VagaJpaRepository vagaRepository;
  private final ParquimetroJpaRepository parquimetroRepository;

  @Override
  @Transactional
  public VagaDatabaseDTO save(VagaDatabaseDTO vagaDatabaseDTO) {
    ParquimetroEntity parquimetro =
        parquimetroRepository
            .findById(vagaDatabaseDTO.getParquimetroId())
            .orElseThrow(() -> new RuntimeException("Parquimetro não encontrado"));

    VagaEntity newVaga = VagaEntity.builder().placa(vagaDatabaseDTO.getPlaca()).parquimetro(parquimetro).build();

    try {
      return vagaRepository.save(newVaga).toDatabaseDTO();
    } catch (DataAccessException e) {
      throw new RuntimeException("Erro ao criar vaga", e);
    }
  }
}
