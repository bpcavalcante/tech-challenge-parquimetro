package com.fiap.parquimetro.domain;

import com.fiap.parquimetro.infrastructure.entities.EnderecoEntity;
import com.fiap.parquimetro.infrastructure.entities.VagaEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Parquimetro {


    private Long id;
    private BigDecimal valorHora;
    private EnderecoEntity endereco;

}
