package com.example.crudgames.domain.model;

import com.example.crudgames.domain.dto.console.RegisterConsoleDTO;
import com.example.crudgames.domain.dto.console.UpdateConsoleDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "console")
@Entity(name = "Console")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Console {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "datalancamento")
    private LocalDate dataLancamento;

    private String empresa;

    private boolean ativo;

    public Console(RegisterConsoleDTO data) {
        this.nome = data.nome();
        this.dataLancamento = data.dataLancamento();
        this.empresa = data.empresa();
        this.ativo = true;
    }

}
