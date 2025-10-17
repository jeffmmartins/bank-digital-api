package com.github.jeffmmartins.digital_bank_api.service;

import com.github.jeffmmartins.digital_bank_api.dto.transacao.DepositoRequestDTO;
import com.github.jeffmmartins.digital_bank_api.dto.transacao.SaqueRequestDTO;
import com.github.jeffmmartins.digital_bank_api.model.Conta;
import com.github.jeffmmartins.digital_bank_api.model.Transacao;
import com.github.jeffmmartins.digital_bank_api.model.enums.TipoTransacao;
import com.github.jeffmmartins.digital_bank_api.repository.ClienteRepository;
import com.github.jeffmmartins.digital_bank_api.repository.ContaRepository;
import com.github.jeffmmartins.digital_bank_api.repository.TransacaoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.LockModeType;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Tag(name = "Transações", description = "Operações relacionadas a transações bancárias")
public class TransacaoService {

    private final ClienteRepository clienteRepository;
    private final ContaRepository contaRepository;
    private final TransacaoRepository transacaoRepository;

    /**
     * Realiza um saque na conta especificada
     * 
     * @param saqueRequestDTO Dados do saque a ser realizado
     * @return A conta atualizada após o saque
     * @throws IllegalArgumentException se a conta não for encontrada ou o saldo for insuficiente
     */
    @Transactional
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Operation(summary = "Realizar saque", description = "Realiza um saque na conta especificada")
    public Conta sacarDinheiro(SaqueRequestDTO saqueRequestDTO) {
        Conta conta = contaRepository.findById(saqueRequestDTO.getContaId())
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada."));

        BigDecimal saldoAtual = BigDecimal.valueOf(conta.getSaldoDaConta());
        
        if (saldoAtual.compareTo(saqueRequestDTO.getValor()) < 0) {
            throw new IllegalArgumentException("Saldo Insuficiente");
        }

        // Registra a transação
        Transacao transacao = new Transacao();
        transacao.setConta(conta);
        transacao.setValorDaTransacao(saqueRequestDTO.getValor().doubleValue());
        transacao.setTipoDeTransacao(TipoTransacao.SAQUE);
        transacao.setDataDaTransacao(LocalDateTime.now());
        transacaoRepository.save(transacao);

        // Atualiza o saldo da conta
        BigDecimal novoSaldo = saldoAtual.subtract(saqueRequestDTO.getValor());
        conta.setSaldoDaConta(novoSaldo.doubleValue());

        // Salva no banco de dados a conta com o novo valor do saldo
        return contaRepository.save(conta);
    }

    /**
     * Realiza um depósito na conta especificada
     * 
     * @param depositoRequestDTO Dados do depósito a ser realizado
     * @return A conta atualizada após o depósito
     * @throws IllegalArgumentException se a conta não for encontrada ou o valor for inválido
     */
    @Transactional
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Operation(summary = "Realizar depósito", description = "Realiza um depósito na conta especificada")
    public Conta depositarDinheiro(DepositoRequestDTO depositoRequestDTO) {
        if (depositoRequestDTO.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser maior que zero.");
        }

        Conta conta = contaRepository.findById(depositoRequestDTO.getContaId())
                .orElseThrow(() -> new IllegalArgumentException("Conta não cadastrada"));

        // Registra a transação
        Transacao transacao = new Transacao();
        transacao.setConta(conta);
        transacao.setValorDaTransacao(depositoRequestDTO.getValor().doubleValue());
        transacao.setTipoDeTransacao(TipoTransacao.DEPOSITO);
        transacao.setDataDaTransacao(LocalDateTime.now());
        transacaoRepository.save(transacao);

        // Atualiza o saldo da conta
        BigDecimal saldoAtual = BigDecimal.valueOf(conta.getSaldoDaConta());
        BigDecimal novoSaldo = saldoAtual.add(depositoRequestDTO.getValor());
        conta.setSaldoDaConta(novoSaldo.doubleValue());

        return contaRepository.save(conta);
    }
}
