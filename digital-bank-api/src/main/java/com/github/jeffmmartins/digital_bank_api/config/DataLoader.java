package com.github.jeffmmartins.digital_bank_api.config;

import com.github.jeffmmartins.digital_bank_api.model.Cliente;
import com.github.jeffmmartins.digital_bank_api.model.Conta;
import com.github.jeffmmartins.digital_bank_api.repository.ClienteRepository;
import com.github.jeffmmartins.digital_bank_api.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        // Cria clientes de teste
        Cliente cliente1 = new Cliente();
        cliente1.setNome("João Silva");
        cliente1.setCpf("123.456.789-00");
        cliente1.setEmail("joao@email.com");
        cliente1.setDataDeNascimento(LocalDate.of(1990, 1, 15));
        cliente1.setTelefone("(11) 98765-4321");
        cliente1 = clienteRepository.save(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria Oliveira");
        cliente2.setCpf("987.654.321-00");
        cliente2.setEmail("maria@email.com");
        cliente2.setDataDeNascimento(LocalDate.of(1985, 5, 20));
        cliente2.setTelefone("(11) 91234-5678");
        cliente2 = clienteRepository.save(cliente2);

        // Cria contas de teste
        Conta conta1 = new Conta();
        conta1.setCliente(cliente1);
        conta1.setNumeroDaConta("1001");
        conta1.setAgencia("0001");
        conta1.setSaldoDaConta(1000.0);
        contaRepository.save(conta1);

        Conta conta2 = new Conta();
        conta2.setCliente(cliente2);
        conta2.setNumeroDaConta("2002");
        conta2.setAgencia("0001");
        conta2.setSaldoDaConta(2500.0);
        contaRepository.save(conta2);
    }
}