package com.example.crudgames.repository;

import com.example.crudgames.model.Console;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsoleRepository extends JpaRepository<Console, Long> {
    Page<Console> findAllByAtivoTrue(Pageable pageable);
}
