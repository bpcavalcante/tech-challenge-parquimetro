package com.fiap.parquimetro.domain;

import com.fiap.parquimetro.infrastructure.entities.VagaEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pagamento {

    private Long id;
    private BigDecimal valor;
    private String metodoPagamento;
    private Vaga vaga;

}
