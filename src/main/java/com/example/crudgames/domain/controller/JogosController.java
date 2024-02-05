package com.example.crudgames.domain.controller;


import com.example.crudgames.domain.dto.jogos.DetailsJogosDTO;
import com.example.crudgames.domain.dto.jogos.ListAllJogosDTO;
import com.example.crudgames.domain.dto.jogos.RegisterJogosDTO;
import com.example.crudgames.domain.dto.jogos.UpdateJogosDTO;
import com.example.crudgames.domain.service.JogosService;
import com.example.crudgames.domain.model.Jogos;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/jogos")
@RequiredArgsConstructor
public class JogosController {

    private final JogosService jogosService;

    @PostMapping
    @Transactional
    public ResponseEntity<DetailsJogosDTO> createGame(@RequestBody @Valid RegisterJogosDTO jogosDTO, UriComponentsBuilder uriBuilder) {
        Jogos jogos = jogosService.create(jogosDTO);

        var uri =uriBuilder.path("/jogos/{id}").buildAndExpand(jogos.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailsJogosDTO(jogos));
    }

    @GetMapping
    public ResponseEntity<Page<ListAllJogosDTO>> listAllGames(@PageableDefault(size = 5, sort = {"nome"}) Pageable pageable) {
        Page<ListAllJogosDTO> listAllGames = jogosService.listAll(pageable);
        return ResponseEntity.ok(listAllGames);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetailsJogosDTO> updateGame(@RequestBody @Valid UpdateJogosDTO gameDTO) {
        Jogos updatedGame = jogosService.update(gameDTO);
        return ResponseEntity.ok(new DetailsJogosDTO(updatedGame));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        jogosService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
