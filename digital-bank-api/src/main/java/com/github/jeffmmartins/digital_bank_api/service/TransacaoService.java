package com.github.jeffmmartins.digital_bank_api.service;

import com.github.jeffmmartins.digital_bank_api.model.Conta;
import com.github.jeffmmartins.digital_bank_api.repository.ClienteRepository;
import com.github.jeffmmartins.digital_bank_api.repository.ContaRepository;
import jakarta.persistence.LockModeType;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class TransacaoService {

    private final ClienteRepository clienteRepository;
    private final ContaRepository contaRepository;


    @Transactional
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public Conta sacarDinheiro(Long idConta, double valorDoSaque){
        Conta conta = contaRepository.findById(idConta)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada."));

        if (conta.getSaldoDaConta() < valorDoSaque) {
            throw new IllegalArgumentException("Saldo Insuficiente");
        }

        //Caso o saque seja efetivado, é atualizado o novo valor da conta
        conta.setSaldoDaConta(conta.getSaldoDaConta()-valorDoSaque);

        //Salva no banco de dados a conta com o novo valor do saldo.
        return contaRepository.save(conta);
    }

    @Transactional
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public Conta depositarDinheiro(Long id, double valorDoDeposito){

        if (valorDoDeposito <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser maior que zero.");
        }

        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Conta não cadastrada"));

        //Atualizando o saldo da conta acrescentado o valor depositado.
        conta.setSaldoDaConta(conta.getSaldoDaConta()+valorDoDeposito);

        return contaRepository.save(conta);
    }
}
