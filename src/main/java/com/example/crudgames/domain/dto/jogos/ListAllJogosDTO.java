package com.example.crudgames.domain.dto.jogos;

import com.example.crudgames.domain.model.Console;
import com.example.crudgames.domain.model.Dev;
import com.example.crudgames.domain.model.Jogos;

import java.time.LocalDate;
import java.util.Set;

public record ListAllJogosDTO(
        Long id,
        String nome,
        String descricao,
        LocalDate dataLancamento,

        Dev desenvolvedorId,
        String genero,
        String urlCapa,
        Set<Console> consoleId

) {

    public ListAllJogosDTO(Jogos jogos){
        this(
                jogos.getId(),
                jogos.getNome(),
                jogos.getDescricao(),
                jogos.getDataLancamento(),
                jogos.getDesenvolvedor(),
                jogos.getGenero(),
                jogos.getUrlCapa(),
                jogos.getConsoles()
        );
    }
}
