package com.br.dsena.agendadejogos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String timeMandante;

    private String timeAdversario;


//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private String dataPartida;

    public String setDataPartida(Date dataPartida) throws ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return this.dataPartida = fmt.format(dataPartida);
    }
}
