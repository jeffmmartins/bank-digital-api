package com.github.jeffmmartins.digital_bank_api.controller;

import com.github.jeffmmartins.digital_bank_api.dto.transacao.DepositoRequestDTO;
import com.github.jeffmmartins.digital_bank_api.dto.transacao.SaqueRequestDTO;
import com.github.jeffmmartins.digital_bank_api.dto.transacao.SaqueResponseDTO;
import com.github.jeffmmartins.digital_bank_api.dto.transacao.TransacaoResponseDTO;
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
    
    /**
     * Endpoint para realizar um saque
     * 
     * @param saqueDTO Dados do saque a ser realizado
     * @return Resposta com os detalhes da operação
     */
    @PostMapping("/saque")
    @Operation(summary = "Realizar saque", description = "Realiza um saque na conta especificada")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Saque realizado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos ou saldo insuficiente", 
                    content = @Content(schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "404", description = "Conta não encontrada")
    })
    public ResponseEntity<SaqueResponseDTO> realizarSaque(@Valid @RequestBody SaqueRequestDTO saqueDTO) {
        // Chama o serviço para realizar o saque
        Conta contaAtualizada = transacaoService.sacarDinheiro(saqueDTO);
        
        // Cria o DTO de resposta
        SaqueResponseDTO responseDTO = new SaqueResponseDTO();
        responseDTO.setContaId(contaAtualizada.getId());
        responseDTO.setValorSacado(saqueDTO.getValor());
        responseDTO.setSaldoAtual(BigDecimal.valueOf(contaAtualizada.getSaldoDaConta()));
        responseDTO.setDataTransacao(LocalDateTime.now());
        responseDTO.setMensagem("Saque realizado com sucesso");
        
        return ResponseEntity.ok(responseDTO);
    }
    
    /**
     * Endpoint para realizar um depósito
     * 
     * @param depositoDTO Dados do depósito a ser realizado
     * @return Resposta com os detalhes da operação
     */
    @PostMapping("/deposito")
    @Operation(summary = "Realizar depósito", description = "Realiza um depósito na conta especificada")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Depósito realizado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos", 
                    content = @Content(schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "404", description = "Conta não encontrada")
    })
    public ResponseEntity<SaqueResponseDTO> realizarDeposito(@Valid @RequestBody DepositoRequestDTO depositoDTO) {
        // Chama o serviço para realizar o depósito
        Conta contaAtualizada = transacaoService.depositarDinheiro(depositoDTO);
        
        // Cria o DTO de resposta
        SaqueResponseDTO responseDTO = new SaqueResponseDTO();
        responseDTO.setContaId(contaAtualizada.getId());
        responseDTO.setValorSacado(depositoDTO.getValor()); // Aqui seria o valor depositado
        responseDTO.setSaldoAtual(BigDecimal.valueOf(contaAtualizada.getSaldoDaConta()));
        responseDTO.setDataTransacao(LocalDateTime.now());
        responseDTO.setMensagem("Depósito realizado com sucesso");
        
        return ResponseEntity.ok(responseDTO);
    }
}