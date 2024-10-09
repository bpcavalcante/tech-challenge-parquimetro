package com.fiap.parquimetro.infrastructure.implementations;

import com.fiap.parquimetro.domain.ParquimetroRepositoryPort;
import com.fiap.parquimetro.domain.ports.dto.ParquimetroDatabaseDTO;
import com.fiap.parquimetro.infrastructure.ParquimetroJpaRepository;
import com.fiap.parquimetro.infrastructure.entities.EnderecoEntity;
import com.fiap.parquimetro.infrastructure.entities.ParquimetroEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;

@RequiredArgsConstructor
public class ParquimetroSqlRepositoryImpl implements ParquimetroRepositoryPort {

  private final ParquimetroJpaRepository parquimetroRepository;

  @Override
  @Transactional(Transactional.TxType.REQUIRED)
  public ParquimetroDatabaseDTO save(ParquimetroDatabaseDTO parquimetroDatabaseDTO) {
    // TODO : Validar se o endereço já existe pelo cep
    EnderecoEntity endereco = EnderecoEntity.builder()
        .cep(parquimetroDatabaseDTO.getCep())
        .complemento(parquimetroDatabaseDTO.getComplemento())
        .numero(parquimetroDatabaseDTO.getNumero())
        .build();

    ParquimetroEntity newParquimetro = ParquimetroEntity.builder()
        .nome(parquimetroDatabaseDTO.getNome())
        .valorHora(parquimetroDatabaseDTO.getValorHora())
        .endereco(endereco)
        .build();

    endereco.setParquimetro(newParquimetro);

    try {
      return parquimetroRepository.save(newParquimetro).toDatabaseDTO();
    } catch (DataAccessException e) {
      throw new RuntimeException("Erro ao criar parquimetro", e);
    }
  }
}
