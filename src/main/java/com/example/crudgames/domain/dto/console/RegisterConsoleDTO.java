package com.example.crudgames.domain.dto.console;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record RegisterConsoleDTO(
        @NotBlank
        String nome,

        LocalDate dataLancamento,
        @NotBlank
        String empresa
) {
}
