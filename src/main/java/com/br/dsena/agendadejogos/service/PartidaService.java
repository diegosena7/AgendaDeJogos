package com.br.dsena.agendadejogos.service;

import com.br.dsena.agendadejogos.model.PartidaRequestDTO;
import com.br.dsena.agendadejogos.model.PartidaResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PartidaService {

    List<PartidaResponseDTO> getAllPartidas();

    PartidaResponseDTO insertPartida(PartidaRequestDTO partidaEntityRequest);

    PartidaResponseDTO getPartydaById(Long id) throws Exception;

    PartidaResponseDTO updatePartida(Long id, PartidaRequestDTO partidaEntityRequest) throws Exception;
}
