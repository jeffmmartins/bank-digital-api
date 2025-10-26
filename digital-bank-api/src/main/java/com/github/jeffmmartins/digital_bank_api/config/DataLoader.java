package com.github.jeffmmartins.digital_bank_api.config;

import com.github.jeffmmartins.digital_bank_api.model.Cliente;
import com.github.jeffmmartins.digital_bank_api.model.Conta;
import com.github.jeffmmartins.digital_bank_api.repository.ClienteRepository;
import com.github.jeffmmartins.digital_bank_api.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

import java.time.LocalDate;

/**
 * Classe responsável por carregar dados iniciais para teste
 */
@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ClienteRepository clienteRepository;
    private final ContaRepository contaRepository;

    @Override
    public void run(String... args) {
        // Cria clientes
        Cliente cliente1 = new Cliente("João Silva", "123.456.789-00");
        cliente1 = clienteRepository.save(cliente1);

        Cliente cliente2 = new Cliente("Maria Oliveira", "987.654.321-00");
        cliente2 = clienteRepository.save(cliente2);

        // Cria contas
        // CORREÇÃO: Usando BigDecimal para o saldo
        Conta conta1 = new Conta("1001", "0001", cliente1, new BigDecimal("1000.00"));
        contaRepository.save(conta1);

        Conta conta2 = new Conta("2002", "0001", cliente2, new BigDecimal("2500.00"));
        contaRepository.save(conta2);
    }
}
