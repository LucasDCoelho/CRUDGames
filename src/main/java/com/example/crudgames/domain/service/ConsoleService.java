package com.example.crudgames.domain.service;

import com.example.crudgames.domain.dto.console.ListAllConsoleDTO;
import com.example.crudgames.domain.dto.console.RegisterConsoleDTO;
import com.example.crudgames.domain.dto.console.UpdateConsoleDTO;
import com.example.crudgames.domain.dto.jogos.ListAllJogosDTO;
import com.example.crudgames.domain.model.Console;
import com.example.crudgames.domain.repository.ConsoleRepository;
import com.example.crudgames.infra.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsoleService {

    private final ConsoleRepository consoleRepository;


    public Console create(RegisterConsoleDTO consoleDTO){
        Console console = new Console(consoleDTO);
        return consoleRepository.save(console);
    }

    public Page<ListAllConsoleDTO> listAll(Pageable pageable) {
        return consoleRepository.findAllByAtivoTrue(pageable).map(ListAllConsoleDTO::new);
    }

    public Console update(UpdateConsoleDTO consoleDTO) {
        Console console = consoleRepository.findById(consoleDTO.id())
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o esse id de console: " + consoleDTO.id()));

        if (consoleDTO.nome() != null){
            console.setNome(consoleDTO.nome());
        }
        if (consoleDTO.dataLancamento() != null){
            console.setDataLancamento(consoleDTO.dataLancamento());
        }
        if (consoleDTO.empresa() != null){
            console.setEmpresa(consoleDTO.empresa());
        }

        return consoleRepository.save(console);
    }


    public void delete(Long consoleId) {
        Console console = consoleRepository.findById(consoleId)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o esse id de console:  " + consoleId));
        console.setAtivo(false);
    }
}
