package com.example.crudgames.dto.console;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateConsoleDTO(
        @NotNull
        Long id,
        String nome,
        LocalDate dataLancamento,

        String empresa
){}