package com.example.crudgames.domain.service;

import com.example.crudgames.domain.dto.dev.DetailDevDTO;
import com.example.crudgames.domain.dto.dev.ListAllDevDTO;
import com.example.crudgames.domain.dto.dev.RegisterDevDTO;
import com.example.crudgames.domain.dto.dev.UpdateDevDTO;
import com.example.crudgames.domain.model.Dev;
import com.example.crudgames.domain.repository.DevRepository;
import com.example.crudgames.infra.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DevService {

    private final DevRepository devRepository;

    public Dev create(RegisterDevDTO data) {
        Dev dev = new Dev(data);
        return devRepository.save(dev);
    }

    public Page<ListAllDevDTO> listAll(Pageable pageable) {
        return devRepository.findAllByAtivoTrue(pageable).map(ListAllDevDTO::new);
    }

    public Dev update(UpdateDevDTO data) {
        Dev dev = devRepository.findById(data.id())
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o esse id de desenvolvedor: " + data.id()));
        if (data.nome() != null){
            dev.setNome(data.nome());
        }
        if (data.dataFundacao() != null){
            dev.setDataFundacao(data.dataFundacao());
        }
        if (data.website() != null){
            dev.setWebsite(data.website());
        }
        if (data.sede() != null){
            dev.setSede(data.sede());
        }

        return devRepository.save(dev);
    }

    public void delete(Long id) {
        Dev dev = devRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o esse id de desenvolvedor: " + id));
        dev.setAtivo(false);
    }
}
