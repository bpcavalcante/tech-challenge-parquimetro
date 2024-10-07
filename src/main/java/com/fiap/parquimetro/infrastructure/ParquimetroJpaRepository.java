package com.fiap.parquimetro.infrastructure;

import com.fiap.parquimetro.infrastructure.entities.ParquimetroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParquimetroJpaRepository extends JpaRepository<ParquimetroEntity, Long> {}
