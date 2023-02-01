package com.br.dsena.agendadejogos.controller;


import com.br.dsena.agendadejogos.model.PartidaRequestDTO;
import com.br.dsena.agendadejogos.model.PartidaResponseDTO;
import com.br.dsena.agendadejogos.service.PartidaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/partidas")
public class PartidaController {

    PartidaService partidaService;

    @Autowired
    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @GetMapping
    public ResponseEntity<List<PartidaResponseDTO>> getAllPartidas(){
        log.info("Método getAllPartidas incializado na classe Controller");
        return ResponseEntity.ok().body(partidaService.getAllPartidas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidaResponseDTO> getPartydaById(@PathVariable("id") Long id) throws Exception {
        log.info("Método getPartydaById incializado na classe Controller");
        return ResponseEntity.ok().body(partidaService.getPartydaById(id));
    }

    @PostMapping
    public ResponseEntity<PartidaResponseDTO> insertPatida(@RequestBody @Valid final PartidaRequestDTO partidaEntityRequest){
        log.info("Método insertPatida incializado na classe Controller");
        return ResponseEntity.ok().body(partidaService.insertPartida(partidaEntityRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartidaResponseDTO> updatePartida(@PathVariable("id") Long id, @RequestBody @Valid final PartidaRequestDTO partidaEntityRequest) throws Exception {
        log.info("Método updatePartida incializado na classe Controller");
        return ResponseEntity.ok().body(partidaService.updatePartida(id, partidaEntityRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PartidaResponseDTO> deletePartida(@PathVariable("id")Long id) throws Exception {
        log.info("Método deletePartida incializado na classe Controller");
        partidaService.deletePartida(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
