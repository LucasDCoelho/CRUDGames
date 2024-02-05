package com.example.crudgames.domain.dto.dev;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record RegisterDevDTO(

        @NotBlank
        String nome,

        LocalDate dataFundacao,

        @NotBlank
        String website,

        @NotBlank
        String sede
) {
}
