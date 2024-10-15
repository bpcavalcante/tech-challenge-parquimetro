package com.fiap.parquimetro.application.controller;

import com.fiap.parquimetro.application.controller.dto.input.PagamentoInput;
import com.fiap.parquimetro.application.controller.dto.output.PagamentoOutput;
import com.fiap.parquimetro.application.ports.CreatePagamentoUseCasePorts;
import com.fiap.parquimetro.application.ports.dto.PagamentoDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
@RequiredArgsConstructor
public class PagamentoController {

  private final CreatePagamentoUseCasePorts createPagamentoUseCasePorts;

  @PostMapping
  public ResponseEntity<PagamentoOutput> criarPagamento (@Valid @RequestBody PagamentoInput pagamentoInput){
    PagamentoDTO pagamentoDTO = createPagamentoUseCasePorts.criar(pagamentoInput.pagamentoInputToDTO());
    return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(pagamentoDTO.toOutput());
  }
}
