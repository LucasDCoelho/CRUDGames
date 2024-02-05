package com.example.crudgames.domain.controller;

import com.example.crudgames.domain.dto.dev.DetailDevDTO;
import com.example.crudgames.domain.dto.dev.ListAllDevDTO;
import com.example.crudgames.domain.dto.dev.RegisterDevDTO;
import com.example.crudgames.domain.dto.dev.UpdateDevDTO;
import com.example.crudgames.domain.model.Dev;
import com.example.crudgames.domain.repository.DevRepository;
import com.example.crudgames.domain.service.DevService;
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
@RequestMapping("/dev")
@RequiredArgsConstructor
public class DevController {

    private final DevService devService;

    @PostMapping
    @Transactional
    public ResponseEntity<DetailDevDTO> register(@RequestBody @Valid RegisterDevDTO data, UriComponentsBuilder uriBuilder){
        Dev dev = devService.create(data);

        var uri = uriBuilder.path("/jogos/{id}").buildAndExpand(dev.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailDevDTO(dev));
    }

    @GetMapping
    public ResponseEntity<Page<ListAllDevDTO>> listAll(@PageableDefault(size = 5, sort = {"nome"}) Pageable pageable){
        Page<ListAllDevDTO> page = devService.listAll(pageable);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetailDevDTO> update(@RequestBody @Valid UpdateDevDTO data){
        Dev dev = devService.update(data);
        return ResponseEntity.ok(new DetailDevDTO(dev));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        devService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
