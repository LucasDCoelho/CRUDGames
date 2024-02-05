package com.example.crudgames.domain.dto.console;

import com.example.crudgames.domain.model.Console;

import java.time.LocalDate;

public record DetailConsoleDTO(
        Long id,
        String nome,

        LocalDate dataLancamento,

        String empresa
) {
    public DetailConsoleDTO(Console console){
        this(
                console.getId(),
                console.getNome(),
                console.getDataLancamento(),
                console.getEmpresa()
        );
    }

}
