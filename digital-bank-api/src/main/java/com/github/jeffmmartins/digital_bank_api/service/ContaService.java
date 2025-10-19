package com.github.jeffmmartins.digital_bank_api.service;

import com.github.jeffmmartins.digital_bank_api.model.Conta;
import com.github.jeffmmartins.digital_bank_api.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;

    public List<Conta> listarTodas() {
        return contaRepository.findAll();
    }

    public Optional<Conta> buscarPorId(Long id) {
        return contaRepository.findById(id);
    }

    public List<Conta> buscarPorCliente(Long clienteId) {
        // Necessário método no repository: findByClienteId
        return contaRepository.findByClienteId(clienteId);
    }

    public Conta salvar(Conta conta) {
        // Para criação, recomenda-se usar o construtor de Conta ou um DTO específico,
        // pois alguns campos não possuem setter (numeroDaConta, numeroDaAgencia, cliente).
        return contaRepository.save(conta);
    }

    public boolean existePorId(Long id) {
        return contaRepository.existsById(id);
    }

    public void excluir(Long id) {
        contaRepository.deleteById(id);
    }

    public Optional<Conta> atualizar(Long id, Conta dadosAtualizados) {
        return contaRepository.findById(id).map(conta -> {
            // Atualiza apenas campos mutáveis
            conta.setSaldoDaConta(dadosAtualizados.getSaldoDaConta());
            // numeroDaConta, numeroDaAgencia e cliente não são atualizados (sem setter)
            return contaRepository.save(conta);
        });
    }
}