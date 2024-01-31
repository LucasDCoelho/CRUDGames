package com.example.crudgames.controller;

import com.example.crudgames.dto.console.DetailConsoleDTO;
import com.example.crudgames.dto.console.ListAllConsoleDTO;
import com.example.crudgames.dto.console.RegisterConsoleDTO;
import com.example.crudgames.dto.console.UpdateConsoleDTO;
import com.example.crudgames.dto.dev.DetailDevDTO;
import com.example.crudgames.dto.dev.ListAllDevDTO;
import com.example.crudgames.dto.dev.UpdateDevDTO;
import com.example.crudgames.model.Console;
import com.example.crudgames.model.Dev;
import com.example.crudgames.repository.ConsoleRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/console")
@RequiredArgsConstructor
public class ConsoleController {

    private ConsoleRepository consoleRepository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisterConsoleDTO data){
        var console = new Console(data);
        consoleRepository.save(console);


        return ResponseEntity.ok(new DetailConsoleDTO(console));
    }

    @GetMapping
    public ResponseEntity<Page<ListAllConsoleDTO>> listAll(@PageableDefault(size = 5, sort = {"nome"}) Pageable pageable){
        var page = consoleRepository.findAllByAtivoTrue(pageable).map(ListAllConsoleDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateConsoleDTO data){
        var console = consoleRepository.getReferenceById(data.id());
        console.updateDev(data);
        return ResponseEntity.ok(new DetailConsoleDTO(console));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var console = consoleRepository.getReferenceById(id);
        console.deleteDev();

        return ResponseEntity.noContent().build();
    }
}
