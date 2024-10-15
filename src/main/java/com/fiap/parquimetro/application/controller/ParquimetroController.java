package com.fiap.parquimetro.application.controller;

import com.fiap.parquimetro.application.controller.dto.input.ParquimetroInput;
import com.fiap.parquimetro.application.controller.dto.output.ParquimetroOutput;
import com.fiap.parquimetro.application.ports.CreateParquimetroVagaUseCasePorts;
import com.fiap.parquimetro.application.ports.dto.ParquimetroDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parquimetros")
@RequiredArgsConstructor
public class ParquimetroController {

  private final CreateParquimetroVagaUseCasePorts createParquimetroVagaUseCasePorts;

  @PostMapping
  public ResponseEntity<ParquimetroOutput> create(
      @Valid @RequestBody ParquimetroInput parquimetroInput) {
    ParquimetroDTO parquimetroDTO =
        createParquimetroVagaUseCasePorts.create(parquimetroInput.toDto());
    return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(parquimetroDTO.toOutput());
  }
}
