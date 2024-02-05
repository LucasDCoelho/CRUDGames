package com.example.crudgames.domain.dto.jogos;

import com.example.crudgames.domain.model.Dev;
import com.example.crudgames.domain.model.Console;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Set;

public record RegisterJogosDTO(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        LocalDate dataLancamento,

        Long desenvolvedorId,
        @NotBlank
        String genero,
        @NotBlank
        String urlCapa,
        Set<Long> consoleId

) {
}
