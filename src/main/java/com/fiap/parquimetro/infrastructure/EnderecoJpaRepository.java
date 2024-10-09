package com.fiap.parquimetro.infrastructure;

import com.fiap.parquimetro.infrastructure.entities.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoJpaRepository extends JpaRepository<EnderecoEntity, Long> {}
