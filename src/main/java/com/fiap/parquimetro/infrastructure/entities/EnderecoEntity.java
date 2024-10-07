package com.fiap.parquimetro.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tb_endereco")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String numero;
    private String complemento;
    @OneToOne
    private ParquimetroEntity parquimetro;

}
