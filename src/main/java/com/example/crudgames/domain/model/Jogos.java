package com.example.crudgames.domain.model;

import com.example.crudgames.domain.dto.jogos.RegisterJogosDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Table(name = "jogos")
@Entity(name = "Jogos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Jogos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @Column(name = "datalancamento")
    private LocalDate dataLancamento;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Dev desenvolvedor;

    private String genero;
    @Column(name = "urlcapa")
    private String urlCapa;

    @ManyToMany
    @JoinTable(name = "jogo_console",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "console_id"))
    private Set<Console> consoles;
    private boolean ativo;


    public Jogos(RegisterJogosDTO jogosDTO, Set<Console> consoles, Dev desenvolvedor) {
        this.nome = jogosDTO.nome();
        this.descricao = jogosDTO.descricao();
        this.dataLancamento = jogosDTO.dataLancamento();
        this.desenvolvedor = desenvolvedor;
        this.genero = jogosDTO.genero();
        this.urlCapa = jogosDTO.urlCapa();
        this.consoles = consoles;
        this.ativo = true;
    }
}

