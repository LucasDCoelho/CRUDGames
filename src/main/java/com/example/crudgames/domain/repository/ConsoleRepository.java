package com.example.crudgames.domain.repository;

import com.example.crudgames.domain.model.Console;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsoleRepository extends JpaRepository<Console, Long> {
    Page<Console> findAllByAtivoTrue(Pageable pageable);
}
