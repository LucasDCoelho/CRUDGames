package com.example.crudgames.dto.console;

import com.example.crudgames.model.Console;

import java.time.LocalDate;

public record ListAllConsoleDTO(Long id, String nome, LocalDate dataLancamento, String empresa) {
    public ListAllConsoleDTO(Console console){
        this(
                console.getId(),
                console.getNome(),
                console.getDataLancamento(),
                console.getEmpresa()
        );

    }
}
