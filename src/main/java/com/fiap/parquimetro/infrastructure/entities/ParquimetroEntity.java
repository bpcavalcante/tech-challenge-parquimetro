package com.fiap.parquimetro.infrastructure.entities;

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

    @Id
    @GeneratedValue
    private Long id;
    private BigDecimal valorHora;
    @OneToOne
    private EnderecoEntity endereco;
    @OneToMany(mappedBy = "parquimetro")
    private List<VagaEntity> vaga;

}
