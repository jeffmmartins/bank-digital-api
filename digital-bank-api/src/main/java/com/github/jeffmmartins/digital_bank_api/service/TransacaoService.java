package com.github.jeffmmartins.digital_bank_api.service;

import com.github.jeffmmartins.digital_bank_api.model.Cliente;
import com.github.jeffmmartins.digital_bank_api.model.Conta;
import com.github.jeffmmartins.digital_bank_api.repository.ClienteRepository;
import com.github.jeffmmartins.digital_bank_api.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class TransacaoService {

    private final ClienteRepository clienteRepository;
    private final ContaRepository contaRepository;

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

    public Conta depositarDinheiro(Long id, double valorDoDeposito){

    }
}
