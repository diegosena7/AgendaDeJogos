package com.br.dsena.agendadejogos.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Adversario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nomeTime;

    private String nomeResponsavel;

    private String telefoneResponsavel;
}
