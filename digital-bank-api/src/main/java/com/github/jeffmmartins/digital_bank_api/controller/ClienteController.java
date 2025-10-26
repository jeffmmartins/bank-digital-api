package com.github.jeffmmartins.digital_bank_api.controller;

import com.github.jeffmmartins.digital_bank_api.dto.cliente.ClienteRequestDTO;
import com.github.jeffmmartins.digital_bank_api.dto.cliente.ClienteResponseDTO;
import com.github.jeffmmartins.digital_bank_api.model.Cliente;
import com.github.jeffmmartins.digital_bank_api.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
@AllArgsConstructor
@Tag(name = "Clientes", description = "Operações relacionadas a clientes")
public class ClienteController {

    private final ClienteService clienteService;

    // --- MÉTODOS DE MAPEAMENTO DTO <-> ENTIDADE ---

    private ClienteResponseDTO toResponseDTO(Cliente cliente) {
        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setCpf(cliente.getCpf());
        return dto;
    }

    private Cliente toEntity(ClienteRequestDTO dto) {
        // Usa o construtor que aceita os campos imutáveis (cpf)
        return new Cliente(dto.getNome(), dto.getCpf());
    }

    // --- ENDPOINTS CORRIGIDOS ---

    @GetMapping
    @Operation(summary = "Listar todos os clientes")
    public ResponseEntity<List<ClienteResponseDTO>> listarTodos() {
        List<Cliente> clientes = clienteService.listarTodos();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        // Converte a lista de Entidades para DTOs
        List<ClienteResponseDTO> dtos = clientes.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cliente por ID")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .map(this::toResponseDTO) // Converte a Entidade para DTO
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Cadastrar cliente")
    public ResponseEntity<ClienteResponseDTO> cadastrar(@Valid @RequestBody ClienteRequestDTO clienteDTO) {
        // Converte DTO para Entidade
        Cliente cliente = toEntity(clienteDTO);
        Cliente clienteSalvo = clienteService.salvar(cliente);
        // Converte Entidade salva para DTO de resposta
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDTO(clienteSalvo));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar cliente")
    public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ClienteRequestDTO clienteDTO) {
        // Para atualização, o service lida com a lógica
        // O DTO é usado para transportar os novos dados
        Cliente dadosAtualizados = new Cliente();
        dadosAtualizados.setNome(clienteDTO.getNome());
        // O CPF não é atualizado, conforme lógica do service

        return clienteService.atualizar(id, dadosAtualizados)
                .map(this::toResponseDTO) // Converte para DTO
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir cliente")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!clienteService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}