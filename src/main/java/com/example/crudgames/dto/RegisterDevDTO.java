package com.example.crudgames.dto;

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
