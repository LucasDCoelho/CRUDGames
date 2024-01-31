package com.example.crudgames.model;

import com.example.crudgames.dto.console.RegisterConsoleDTO;
import com.example.crudgames.dto.console.UpdateConsoleDTO;
import com.example.crudgames.dto.dev.UpdateDevDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "console")
@Entity(name = "Console")
@Getter
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

    private Boolean ativo;

    public Console(RegisterConsoleDTO data) {
        this.nome = data.nome();
        this.dataLancamento = data.dataLancamento();
        this.empresa = data.empresa();
        this.ativo = true;
    }

    public void updateDev(UpdateConsoleDTO data) {
        if (data.nome() != null){
            this.nome = data.nome();
        }
        if (data.dataLancamento() != null){
            this.dataLancamento = data.dataLancamento();
        }
        if (data.empresa() != null){
            this.empresa = data.empresa();
        }
    }

    public void deleteDev() {
        this.ativo = false;
    }
}
