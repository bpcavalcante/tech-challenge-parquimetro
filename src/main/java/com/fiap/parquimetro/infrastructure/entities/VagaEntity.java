package com.fiap.parquimetro.infrastructure.entities;

import com.fiap.parquimetro.application.ports.dto.VagaDTO;
import com.fiap.parquimetro.domain.ports.dto.VagaDatabaseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "tb_vaga")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class VagaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Instant dataHoraInicio;
  private Instant dataHoraFim;
  private Double tempoPermanencia;
  private String placa;
  private boolean isPresentCarro;
  @ManyToOne private ParquimetroEntity parquimetro;
  @OneToOne(cascade = CascadeType.PERSIST) private PagamentoEntity pagamento;

  public VagaDTO toDTO() {
    return VagaDTO.builder()
        .id(this.id)
        .dataHoraInicio(this.dataHoraInicio)
        .placa(this.placa)
        .parquimetro(this.parquimetro.getId())
        .build();
  }

  public VagaDatabaseDTO toDatabaseDTO() {
    return VagaDatabaseDTO.builder()
        .id(this.id)
        .dataHoraInicio(this.dataHoraInicio)
        .placa(this.placa)
        .parquimetroId(this.parquimetro.getId())
        .parquimetroValorHora(this.parquimetro.getValorHora())
        .parquimetroNome(this.parquimetro.getNome())
        .enderecoNumero(this.parquimetro.getEndereco().getNumero())
        .enderecoCep(this.parquimetro.getEndereco().getCep())
        .enderecoId(this.parquimetro.getEndereco().getId())
        .enderecoComplemento(this.parquimetro.getEndereco().getComplemento())
        .isPresentCarro(this.isPresentCarro)
        .build();
  }
}
