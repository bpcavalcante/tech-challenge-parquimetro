package com.fiap.parquimetro.application.controller;

import com.fiap.parquimetro.application.controller.dto.input.VagaInput;
import com.fiap.parquimetro.application.controller.dto.output.VagaOutput;
import com.fiap.parquimetro.application.ports.CreateIniciarVagaUseCasePorts;
import com.fiap.parquimetro.application.ports.EncerrarVagaUseCasePorts;
import com.fiap.parquimetro.application.ports.dto.VagaDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vagas")
@RequiredArgsConstructor
public class VagaController {

  private final CreateIniciarVagaUseCasePorts createIniciarVagaUseCasePorts;
  private final EncerrarVagaUseCasePorts encerrarVagaUseCasePorts;

  @PostMapping
  public ResponseEntity<VagaOutput> iniciarVaga(@Valid @RequestBody VagaInput vagaInput) {
    VagaDTO vagaDTO = createIniciarVagaUseCasePorts.iniciarVaga(vagaInput.toDto());
    return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(vagaDTO.toOutput());
  }

  @PutMapping
  public ResponseEntity<VagaOutput> encerrarVaga(@Valid @RequestBody VagaInput vagaInput) {
    VagaDTO vagaDTO = encerrarVagaUseCasePorts.encerrarVaga(vagaInput.toDto());
    return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(vagaDTO.toOutput());
  }
}
