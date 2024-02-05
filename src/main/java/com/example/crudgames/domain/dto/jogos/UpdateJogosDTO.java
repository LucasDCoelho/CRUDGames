package com.example.crudgames.domain.dto.jogos;

import com.example.crudgames.domain.model.Console;
import com.example.crudgames.domain.model.Dev;
import com.example.crudgames.domain.model.Jogos;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Set;

public record UpdateJogosDTO(
        @NotNull
        Long id,
        String nome,
        LocalDate dataLancamento,
        String descricao,
        String genero,
        String urlCapa
) {
}
