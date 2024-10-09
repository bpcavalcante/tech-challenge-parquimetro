package com.fiap.parquimetro.infrastructure.entities;

import com.fiap.parquimetro.domain.ports.dto.ParquimetroDatabaseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_parquimetro")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ParquimetroEntity {

  @Id @GeneratedValue private Long id;
  private Double valorHora;

  private String nome;

  @OneToOne(cascade = CascadeType.PERSIST)
  private EnderecoEntity endereco;

  @OneToMany(mappedBy = "parquimetro")
  private List<VagaEntity> vaga;

  public ParquimetroDatabaseDTO toDatabaseDTO() {
    return ParquimetroDatabaseDTO.builder()
        .id(this.id)
        .valorHora(this.valorHora)
        .nome(this.nome)
        .enderecoId(this.endereco.getId())
        .cep(this.endereco.getCep())
        .complemento(this.endereco.getComplemento())
        .numero(this.endereco.getNumero())
        .build();
  }
}
