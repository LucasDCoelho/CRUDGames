package com.example.crudgames.domain.dto.dev;

import com.example.crudgames.domain.model.Dev;

import java.time.LocalDate;

public record DetailDevDTO(
        Long id,
        String nome,
        LocalDate dataFundacao,
        String website,
        String sede
) {
    public DetailDevDTO(Dev dev){
        this(
                dev.getId(),
                dev.getNome(),
                dev.getDataFundacao(),
                dev.getWebsite(),
                dev.getSede()
        );
    }
}
