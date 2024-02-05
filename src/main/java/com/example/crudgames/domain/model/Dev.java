package com.example.crudgames.domain.model;

import com.example.crudgames.domain.dto.dev.RegisterDevDTO;
import com.example.crudgames.domain.dto.dev.UpdateDevDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "dev")
@Entity(name = "Dev")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Dev {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(name = "datafundacao")
    private LocalDate dataFundacao;

    private String website;
    private String sede;
    private Boolean ativo;

    public Dev(RegisterDevDTO data) {
        this.nome = data.nome();
        this.dataFundacao = data.dataFundacao();
        this.website = data.website();
        this.sede = data.sede();
        this.ativo = true;
    }
}
