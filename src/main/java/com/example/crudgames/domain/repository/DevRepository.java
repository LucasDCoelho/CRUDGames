package com.example.crudgames.domain.repository;

import com.example.crudgames.domain.model.Dev;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevRepository extends JpaRepository<Dev, Long> {
    Page<Dev> findAllByAtivoTrue(Pageable pageable);
}
