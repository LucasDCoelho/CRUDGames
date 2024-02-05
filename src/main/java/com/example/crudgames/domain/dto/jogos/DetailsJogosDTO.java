package com.example.crudgames.domain.dto.jogos;


import com.example.crudgames.domain.model.Console;
import com.example.crudgames.domain.model.Dev;
import com.example.crudgames.domain.model.Jogos;

import java.time.LocalDate;
import java.util.Set;

public record DetailsJogosDTO(
        Long id,
        String nome,
        LocalDate dataLancamento,
        String descricao,
        Set<Console> consoleId,
        String genero,
        String urlCapa,
        Dev desenvolvedorId
) {
    public DetailsJogosDTO(Jogos jogos){
        this(
                jogos.getId(),
                jogos.getNome(),
                jogos.getDataLancamento(),
                jogos.getDescricao(),
                jogos.getConsoles(),
                jogos.getGenero(),
                jogos.getUrlCapa(),
                jogos.getDesenvolvedor()
        );
    }


}
