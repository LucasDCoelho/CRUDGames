package com.example.crudgames.domain.service;

import com.example.crudgames.domain.dto.jogos.ListAllJogosDTO;
import com.example.crudgames.domain.dto.jogos.RegisterJogosDTO;
import com.example.crudgames.domain.dto.jogos.UpdateJogosDTO;
import com.example.crudgames.domain.model.Console;
import com.example.crudgames.domain.model.Dev;
import com.example.crudgames.domain.model.Jogos;
import com.example.crudgames.domain.repository.ConsoleRepository;
import com.example.crudgames.domain.repository.DevRepository;
import com.example.crudgames.domain.repository.JogosRepository;
import com.example.crudgames.infra.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class JogosService {

    private final JogosRepository jogosRepository;
    private final DevRepository devRepository;
    private final ConsoleRepository consoleRepository;

    public Jogos create(RegisterJogosDTO jogosDTO) {
        Dev desenvolvedor = devRepository.findById(jogosDTO.desenvolvedorId())
                .orElseThrow(() -> new ResourceNotFoundException("Desenvolvedor não encontrado com o ID: " + jogosDTO.desenvolvedorId()));

        List<Console> consoleList = consoleRepository.findAllById(jogosDTO.consoleId());
        Set<Console> consoles = new HashSet<>(consoleList);

        Jogos jogo = new Jogos(jogosDTO, consoles, desenvolvedor);
        return jogosRepository.save(jogo);
    }

    public Page<ListAllJogosDTO> listAll(Pageable pageable) {
        return jogosRepository.findAllByAtivoTrue(pageable).map(ListAllJogosDTO::new) ;
    }

    public Jogos update(UpdateJogosDTO jogosDTO) {
        Jogos jogo = jogosRepository.findById(jogosDTO.id())
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o esse id de jogos: " + jogosDTO.id()));;
        if (jogosDTO.nome() != null) {
            jogo.setNome(jogosDTO.nome());
        }
        if (jogosDTO.dataLancamento() != null) {
            jogo.setDataLancamento(jogosDTO.dataLancamento());
        }
        if (jogosDTO.descricao() != null) {
            jogo.setDescricao(jogosDTO.descricao());
        }
        if (jogosDTO.genero() != null) {
            jogo.setGenero(jogosDTO.genero());
        }
        if (jogosDTO.urlCapa() != null) {
            jogo.setUrlCapa(jogosDTO.urlCapa());
        }

        return jogosRepository.save(jogo);
    }

    public void delete(Long jogosId) {
        Jogos jogos = jogosRepository.findById(jogosId)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o esse id de jogos:  " + jogosId));
        jogos.setAtivo(false);
    }
}