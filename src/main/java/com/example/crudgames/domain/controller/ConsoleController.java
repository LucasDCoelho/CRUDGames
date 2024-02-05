package com.example.crudgames.domain.controller;

import com.example.crudgames.domain.dto.console.DetailConsoleDTO;
import com.example.crudgames.domain.dto.console.ListAllConsoleDTO;
import com.example.crudgames.domain.dto.console.RegisterConsoleDTO;
import com.example.crudgames.domain.dto.console.UpdateConsoleDTO;
import com.example.crudgames.domain.dto.jogos.ListAllJogosDTO;
import com.example.crudgames.domain.model.Console;
import com.example.crudgames.domain.repository.ConsoleRepository;
import com.example.crudgames.domain.service.ConsoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/console")
@RequiredArgsConstructor
public class ConsoleController {

    private final ConsoleService consoleService;

    @PostMapping
    @Transactional
    public ResponseEntity<DetailConsoleDTO> create(@RequestBody @Valid RegisterConsoleDTO data, UriComponentsBuilder uriBuilder){
        Console console = consoleService.create(data);

        var uri = uriBuilder.path("/console/{id}").buildAndExpand(console.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailConsoleDTO(console));
    }

    @GetMapping
    public ResponseEntity<Page<ListAllConsoleDTO>> listAll(@PageableDefault(size = 5, sort = {"nome"}) Pageable pageable){
        Page<ListAllConsoleDTO> listAllGames = consoleService.listAll(pageable);
        return ResponseEntity.ok(listAllGames);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetailConsoleDTO> update(@RequestBody @Valid UpdateConsoleDTO data){
        Console console = consoleService.update(data);
        return ResponseEntity.ok(new DetailConsoleDTO(console));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        consoleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
