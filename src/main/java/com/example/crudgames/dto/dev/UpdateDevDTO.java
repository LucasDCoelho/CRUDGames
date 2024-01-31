package com.example.crudgames.dto.dev;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateDevDTO(
        @NotNull
        Long id,
        String nome,
        LocalDate dataFundacao,
        String website,
        String sede
) {
}
