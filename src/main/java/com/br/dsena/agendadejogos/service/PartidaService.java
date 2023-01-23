package com.br.dsena.agendadejogos.service;

import com.br.dsena.agendadejogos.model.Partida;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PartidaService {

    List<Partida> getAllPartidas();

    Partida insertPartida(Partida partidaRequest);
}
