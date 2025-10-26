package com.github.jeffmmartins.digital_bank_api.controller;

import com.github.jeffmmartins.digital_bank_api.dto.transacao.*;
import com.github.jeffmmartins.digital_bank_api.model.Conta;
import com.github.jeffmmartins.digital_bank_api.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Controller responsável por gerenciar as operações de transação bancária
 */
@RestController
@RequestMapping("/api/transacoes")
@AllArgsConstructor
@Tag(name = "Transações", description = "Endpoints para gerenciar transações bancárias")
public class TransacaoController {

    private final TransacaoService transacaoService;

    @PostMapping("/saque")
    // ... (anotações swagger)
    public ResponseEntity<SaqueResponseDTO> realizarSaque(@Valid @RequestBody SaqueRequestDTO saqueDTO) {
        Conta contaAtualizada = transacaoService.sacarDinheiro(saqueDTO);

        SaqueResponseDTO responseDTO = new SaqueResponseDTO();
        responseDTO.setContaId(contaAtualizada.getId());
        responseDTO.setValorSacado(saqueDTO.getValor());
        responseDTO.setSaldoAtual(contaAtualizada.getSaldoDaConta()); // Já é BigDecimal
        responseDTO.setDataTransacao(LocalDateTime.now());
        responseDTO.setMensagem("Saque realizado com sucesso");

        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/deposito")
    // ... (anotações swagger)
    // CORREÇÃO: Retornando o DTO de Depósito
    public ResponseEntity<DepositoResponseDTO> realizarDeposito(@Valid @RequestBody DepositoRequestDTO depositoDTO) {
        Conta contaAtualizada = transacaoService.depositarDinheiro(depositoDTO);

        // CORREÇÃO: Usando o DTO de Depósito
        DepositoResponseDTO responseDTO = new DepositoResponseDTO();
        responseDTO.setContaId(contaAtualizada.getId());
        responseDTO.setValorDepositado(depositoDTO.getValor());
        responseDTO.setSaldoAtual(contaAtualizada.getSaldoDaConta()); // Já é BigDecimal
        responseDTO.setDataTransacao(LocalDateTime.now());
        responseDTO.setMensagem("Depósito realizado com sucesso");

        return ResponseEntity.ok(responseDTO);
    }
}