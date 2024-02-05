package com.example.crudgames.domain.repository;


import com.example.crudgames.domain.model.Dev;
import com.example.crudgames.domain.model.Jogos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogosRepository extends JpaRepository<Jogos, Long> {
    Page<Jogos> findAllByAtivoTrue(Pageable pageable);
}

