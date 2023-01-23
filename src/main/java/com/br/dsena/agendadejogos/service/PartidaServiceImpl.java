package com.br.dsena.agendadejogos.service;

import com.br.dsena.agendadejogos.model.Partida;
import com.br.dsena.agendadejogos.repository.PartidaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PartidaServiceImpl implements PartidaService{

    @Autowired
    PartidaRepository partidaRepository;

    @Override
    public List<Partida> getAllPartidas() {
        log.info("Iniciado a busca das partidas");
        List<Partida> partidas = partidaRepository.findAll();
        if (partidas.isEmpty()){
            log.info("Lista de partidas está vazia");
        }
        return partidas;
    }

    @Override
    public Partida insertPartida(Partida partidaRequest) {
        log.info("Inserindo uma partida");
        return partidaRepository.save(partidaRequest);
    }
}
