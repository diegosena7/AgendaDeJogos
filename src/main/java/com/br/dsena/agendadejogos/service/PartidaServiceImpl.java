package com.br.dsena.agendadejogos.service;

import com.br.dsena.agendadejogos.mapper.PartidaMapper;
import com.br.dsena.agendadejogos.model.PartidaEntity;
import com.br.dsena.agendadejogos.model.PartidaRequestDTO;
import com.br.dsena.agendadejogos.model.PartidaResponseDTO;
import com.br.dsena.agendadejogos.repository.PartidaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PartidaServiceImpl implements PartidaService{

    @Autowired
    PartidaRepository partidaRepository;

    private final PartidaMapper mapper;

    @Override
    public List<PartidaResponseDTO> getAllPartidas() {
        log.info("Iniciado a busca das partidas");
        List<PartidaEntity> partidaEntities = partidaRepository.findAll();
        if (partidaEntities.isEmpty()){
            log.info("Lista de partidas está vazia");
        }
        return mapper.resquestToEntity(partidaEntities);
    }

    @Override
    public PartidaResponseDTO insertPartida(PartidaRequestDTO partidaEntityRequest) {
        log.info("Inserindo uma partida");
        return mapper.resquestToEntity(partidaRepository.save(mapper.toEntity(partidaEntityRequest)));
    }

    public PartidaResponseDTO getPartydaById(Long id) throws Exception {
        log.info("Getting partida id-{}", id);
        Optional<PartidaEntity> partidaById = partidaRepository.findById(id);

        if (partidaById.isEmpty()){
            throw new Exception("Id não existe na base");
        }else{
            return mapper.resquestToEntity(partidaById.get());
        }
    }
}
