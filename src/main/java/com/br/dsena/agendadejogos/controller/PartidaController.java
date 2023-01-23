package com.br.dsena.agendadejogos.controller;

import com.br.dsena.agendadejogos.model.Partida;
import com.br.dsena.agendadejogos.service.PartidaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/partidas")
public class PartidaController {

    @Autowired
    PartidaService partidaService;

    @GetMapping
    public ResponseEntity<List<Partida>> getAllPartidas(){
        log.info("Método getAllPartidas incializado na classe Controller");
        return ResponseEntity.ok().body(partidaService.getAllPartidas());
    }

    @PostMapping
    public ResponseEntity<Partida> insertPatida(@RequestBody Partida partidaRequest){
        return ResponseEntity.ok().body(partidaService.insertPartida(partidaRequest));
    }
}
