package com.github.jeffmmartins.digital_bank_api.service;

import com.github.jeffmmartins.digital_bank_api.model.Cliente;
import com.github.jeffmmartins.digital_bank_api.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente salvar(Cliente cliente) {
        // Para criação/atualização simples. Como o campo cpf não possui setter,
        // recomenda-se criação via construtor no DataLoader ou DTOs específicos.
        return clienteRepository.save(cliente);
    }

    public boolean existePorId(Long id) {
        return clienteRepository.existsById(id);
    }

    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> atualizar(Long id, Cliente dadosAtualizados) {
        return clienteRepository.findById(id).map(cliente -> {
            // Atualiza apenas campos mutáveis
            cliente.setNome(dadosAtualizados.getNome());
            // cpf não é atualizado por design (setter desabilitado)
            return clienteRepository.save(cliente);
        });
    }
}