package com.example.crudgames.dto;

import com.example.crudgames.model.Dev;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ListAllDevDTO(Long id, String nome,LocalDate dataFundacao, String website, String sede) {

    public ListAllDevDTO(Dev dev){
        this(dev.getId(), dev.getNome(), dev.getDataFundacao(), dev.getWebsite(), dev.getSede());
    }
}
