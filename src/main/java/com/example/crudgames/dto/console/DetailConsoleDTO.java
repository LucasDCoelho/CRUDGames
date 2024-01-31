package com.example.crudgames.dto.console;

import com.example.crudgames.model.Console;
import com.example.crudgames.model.Dev;

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
