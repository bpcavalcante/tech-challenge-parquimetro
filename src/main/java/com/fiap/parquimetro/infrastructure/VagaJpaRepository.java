package com.fiap.parquimetro.infrastructure;

import com.fiap.parquimetro.infrastructure.entities.VagaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaJpaRepository extends JpaRepository<VagaEntity, Long> {}
