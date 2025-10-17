package com.github.jeffmmartins.digital_bank_api.controller;

import com.github.jeffmmartins.digital_bank_api.dto.transacao.SaqueRequestDTO;
import com.github.jeffmmartins.digital_bank_api.dto.transacao.SaqueResponseDTO;
import com.github.jeffmmartins.digital_bank_api.model.Conta;
import com.github.jeffmmartins.digital_bank_api.service.TransacaoService;
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
public class TransacaoController {

    private final TransacaoService transacaoService;
    
    /**
     * Endpoint para realizar um saque
     * 
     * @param saqueDTO Dados do saque a ser realizado
     * @return Resposta com os detalhes da operação
     */
    @PostMapping("/saque")
    public ResponseEntity<SaqueResponseDTO> realizarSaque(@Valid @RequestBody SaqueRequestDTO saqueDTO) {
        // Converte o valor para double (temporário até adaptar o service para BigDecimal)
        double valorSaque = saqueDTO.getValor().doubleValue();
        
        // Chama o serviço para realizar o saque
        Conta contaAtualizada = transacaoService.sacarDinheiro(saqueDTO.getContaId(), valorSaque);
        
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
     * @param contaId ID da conta para depósito
     * @param valor Valor a ser depositado
     * @return Resposta com os detalhes da operação
     */
    @PostMapping("/deposito/{contaId}")
    public ResponseEntity<SaqueResponseDTO> realizarDeposito(
            @PathVariable Long contaId,
            @RequestParam BigDecimal valor) {
        
        // Converte o valor para double (temporário até adaptar o service para BigDecimal)
        double valorDeposito = valor.doubleValue();
        
        // Chama o serviço para realizar o depósito
        Conta contaAtualizada = transacaoService.depositarDinheiro(contaId, valorDeposito);
        
        // Cria o DTO de resposta
        SaqueResponseDTO responseDTO = new SaqueResponseDTO();
        responseDTO.setContaId(contaAtualizada.getId());
        responseDTO.setValorSacado(valor); // Aqui seria o valor depositado
        responseDTO.setSaldoAtual(BigDecimal.valueOf(contaAtualizada.getSaldoDaConta()));
        responseDTO.setDataTransacao(LocalDateTime.now());
        responseDTO.setMensagem("Depósito realizado com sucesso");
        
        return ResponseEntity.ok(responseDTO);
    }
}