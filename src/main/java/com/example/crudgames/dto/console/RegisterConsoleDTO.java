package com.example.crudgames.dto.console;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record RegisterConsoleDTO(
        @NotBlank
        String nome,
        @NotBlank
        LocalDate dataLancamento,
        @NotBlank
        String empresa
) {
}
