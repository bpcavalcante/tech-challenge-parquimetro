package com.fiap.parquimetro.application.controller;

import com.fiap.parquimetro.application.controller.dto.VagaInput;
import com.fiap.parquimetro.application.controller.dto.VagaOutput;
import com.fiap.parquimetro.application.ports.CreateIniciarVagaUseCasePorts;
import com.fiap.parquimetro.application.ports.dto.IniciarVagaDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vagas")
@RequiredArgsConstructor
public class VagaController {

  private final CreateIniciarVagaUseCasePorts createIniciarVagaUseCasePorts;

  @PostMapping
  public ResponseEntity<VagaOutput> iniciarVaga(@Valid @RequestBody VagaInput vagaInput) {
    IniciarVagaDTO vagaDTO = createIniciarVagaUseCasePorts.iniciarVaga(vagaInput.toDto());
    return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(vagaDTO.toOutput());
  }
}
