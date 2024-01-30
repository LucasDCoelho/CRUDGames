package com.example.crudgames.model;

import com.example.crudgames.dto.RegisterDevDTO;
import com.example.crudgames.dto.UpdateDevDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "dev")
@Entity(name = "Dev")
@Getter
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

    public void updateDev(UpdateDevDTO data) {
        if (data.nome() != null){
            this.nome = data.nome();
        }
        if (data.dataFundacao() != null){
            this.dataFundacao = data.dataFundacao();
        }
        if (data.website() != null){
            this.website = data.website();
        }
        if (data.sede() != null){
            this.sede = data.sede();
        }
    }

    public void deleteDev(){
        this.ativo = false;
    }
}
