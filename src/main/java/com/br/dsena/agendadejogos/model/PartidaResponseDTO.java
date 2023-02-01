package com.br.dsena.agendadejogos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidaResponseDTO {

    private Long id;

    private String timeMandante;

    private String timeAdversario;

    private Date dataPartida;

}
