package com.fiap.parquimetro.config;

import com.fiap.parquimetro.domain.usecase.CreateIniciarVagaUseCase;
import com.fiap.parquimetro.domain.ports.VagaRepositoryPort;
import com.fiap.parquimetro.infrastructure.ParquimetroJpaRepository;
import com.fiap.parquimetro.infrastructure.VagaJpaRepository;
import com.fiap.parquimetro.infrastructure.implementations.VagaSqlRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer {

  @Bean
  public CreateIniciarVagaUseCase createIniciarVagaUseCase(VagaRepositoryPort vagaRepositoryPort) {
    return new CreateIniciarVagaUseCase(vagaRepositoryPort);
  }

  @Bean
  public VagaSqlRepositoryImpl vagaRepositoryImpl(
      VagaJpaRepository vagaRepository, ParquimetroJpaRepository parquimetroRepository) {
    return new VagaSqlRepositoryImpl(vagaRepository, parquimetroRepository);
  }
}
