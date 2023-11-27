package br.edu.ifsp.rufino.model.usuario;

import jakarta.validation.constraints.NotBlank;
public record dadosAutenticacao(
        @NotBlank
        String login,
        @NotBlank
        String senha) {
}