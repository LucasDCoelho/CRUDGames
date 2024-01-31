package com.example.crudgames.controller;

import com.example.crudgames.dto.dev.DetailDevDTO;
import com.example.crudgames.dto.dev.ListAllDevDTO;
import com.example.crudgames.dto.dev.RegisterDevDTO;
import com.example.crudgames.dto.dev.UpdateDevDTO;
import com.example.crudgames.model.Dev;
import com.example.crudgames.repository.DevRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev")
@RequiredArgsConstructor
public class DevController {

    private final DevRepository devRepository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisterDevDTO data){
        var dev = new Dev(data);
        devRepository.save(dev);


        return ResponseEntity.ok(new DetailDevDTO(dev));
    }

    @GetMapping
    public ResponseEntity<Page<ListAllDevDTO>> listAll(@PageableDefault(size = 5, sort = {"nome"}) Pageable pageable){
        var page = devRepository.findAllByAtivoTrue(pageable).map(ListAllDevDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateDevDTO data){
        var dev = devRepository.getReferenceById(data.id());
        dev.updateDev(data);
        return ResponseEntity.ok(new DetailDevDTO(dev));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var dev =devRepository.getReferenceById(id);
        dev.deleteDev();

        return ResponseEntity.noContent().build();
    }

}
