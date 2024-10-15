package com.fiap.parquimetro.config;

import com.fiap.parquimetro.domain.ports.PagamentoRepositoryPort;
import com.fiap.parquimetro.domain.ports.ParquimetroRepositoryPort;
import com.fiap.parquimetro.domain.usecase.CreateIniciarVagaUseCase;
import com.fiap.parquimetro.domain.ports.VagaRepositoryPort;
import com.fiap.parquimetro.domain.usecase.CreatePagamentoUseCase;
import com.fiap.parquimetro.domain.usecase.CreateParquimetroVagaUseCase;
import com.fiap.parquimetro.domain.usecase.EncerrarVagaUseCase;
import com.fiap.parquimetro.infrastructure.PagamentoJpaRepository;
import com.fiap.parquimetro.infrastructure.ParquimetroJpaRepository;
import com.fiap.parquimetro.infrastructure.VagaJpaRepository;
import com.fiap.parquimetro.infrastructure.implementations.PagamentoSqlRepositoryImpl;
import com.fiap.parquimetro.infrastructure.implementations.ParquimetroSqlRepositoryImpl;
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
  public EncerrarVagaUseCase encerrarVagaUseCase(
      VagaRepositoryPort vagaRepositoryPort) {
    return new EncerrarVagaUseCase(vagaRepositoryPort);
  }

  @Bean
  public CreateParquimetroVagaUseCase createParquimetroVagaUseCase(
      ParquimetroRepositoryPort parquimetroRepositoryPort) {
    return new CreateParquimetroVagaUseCase(parquimetroRepositoryPort);
  }

  @Bean
  public CreatePagamentoUseCase createPagamentoUseCase(
      PagamentoRepositoryPort pagamentoRepositoryPort) {
    return new CreatePagamentoUseCase(pagamentoRepositoryPort);
  }

  @Bean
  public VagaSqlRepositoryImpl vagaRepositoryImpl(
      VagaJpaRepository vagaRepository, ParquimetroJpaRepository parquimetroRepository) {
    return new VagaSqlRepositoryImpl(vagaRepository, parquimetroRepository);
  }

  @Bean
  public PagamentoSqlRepositoryImpl pagamentoRepositoryImpl(
      PagamentoJpaRepository pagamentoJpaRepository, VagaJpaRepository vagaJpaRepository) {
    return new PagamentoSqlRepositoryImpl(pagamentoJpaRepository, vagaJpaRepository);
  }

  @Bean
  public ParquimetroSqlRepositoryImpl parquimetroSqlRepository(
      ParquimetroJpaRepository parquimetroRepository) {
    return new ParquimetroSqlRepositoryImpl(parquimetroRepository);
  }
}
