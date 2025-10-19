package com.github.jeffmmartins.digital_bank_api.controller;

import com.github.jeffmmartins.digital_bank_api.model.Conta;
import com.github.jeffmmartins.digital_bank_api.service.ContaService;
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

@RestController
@RequestMapping("/api/contas")
@AllArgsConstructor
@Tag(name = "Contas", description = "Operações relacionadas a contas bancárias")
public class ContaController {

    private final ContaService contaService;

    @GetMapping
    @Operation(summary = "Listar todas as contas", description = "Retorna uma lista com todas as contas cadastradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contas encontradas com sucesso"),
            @ApiResponse(responseCode = "204", description = "Nenhuma conta encontrada")
    })
    public ResponseEntity<List<Conta>> listarTodas() {
        List<Conta> contas = contaService.listarTodas();
        if (contas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(contas);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar conta por ID", description = "Retorna uma conta específica pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Conta encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Conta não encontrada")
    })
    public ResponseEntity<Conta> buscarPorId(@PathVariable Long id) {
        return contaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{clienteId}")
    @Operation(summary = "Buscar contas por cliente", description = "Retorna todas as contas de um cliente específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contas encontradas com sucesso"),
            @ApiResponse(responseCode = "204", description = "Nenhuma conta encontrada para este cliente")
    })
    public ResponseEntity<List<Conta>> buscarPorCliente(@PathVariable Long clienteId) {
        List<Conta> contas = contaService.buscarPorCliente(clienteId);
        if (contas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(contas);
    }

    @PostMapping
    @Operation(summary = "Cadastrar conta", description = "Cadastra uma nova conta bancária")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Conta cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<Conta> cadastrar(@Valid @RequestBody Conta conta) {
        Conta contaSalva = contaService.salvar(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(contaSalva);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar conta", description = "Atualiza os dados de uma conta existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Conta atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Conta não encontrada"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<Conta> atualizar(@PathVariable Long id, @Valid @RequestBody Conta conta) {
        return contaService.atualizar(id, conta)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir conta", description = "Remove uma conta do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Conta excluída com sucesso"),
            @ApiResponse(responseCode = "404", description = "Conta não encontrada")
    })
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!contaService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        contaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}