package com.fiap.parquimetro.domain;

import com.fiap.parquimetro.infrastructure.entities.ParquimetroEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Endereco {


    private Long id;
    private String cep;
    private String numero;
    private String complemento;
    private Parquimetro parquimetro;

}
