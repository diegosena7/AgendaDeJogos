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

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PartidaServiceImpl implements PartidaService {

    @Autowired
    PartidaRepository partidaRepository;

    private final PartidaMapper mapper;

    @Override
    public List<PartidaResponseDTO> getAllPartidas() {
        log.info("Iniciado a busca das partidas");
        List<PartidaEntity> partidaEntities = partidaRepository.findAll();
        if (partidaEntities.isEmpty()) {
            log.info("Lista de partidas está vazia");
            throw new EntityNotFoundException("Lista de partidas está vazia.");
        }
        return mapper.resquestToEntity(partidaEntities);
    }

    @Override
    public PartidaResponseDTO insertPartida(PartidaRequestDTO partidaEntityRequest) {
        log.info("Inserindo uma partida");
        return mapper.resquestToEntity(partidaRepository.save(mapper.toEntity(partidaEntityRequest)));
    }

    public PartidaResponseDTO getPartydaById(Long id) throws Exception {
        log.info("Buscando partida id-{}", id);
        Optional<PartidaEntity> partidaById = partidaRepository.findById(id);

        if (partidaById.isEmpty()) {
            throw new EntityNotFoundException("Id da partida não existe na base de dados.");
        } else {
            return mapper.resquestToEntity(partidaById.get());
        }
    }

    @Override
    public PartidaResponseDTO updatePartida(Long id, PartidaRequestDTO partidaEntityRequest) throws Exception {
        Objects.requireNonNull(partidaEntityRequest, "request must not be null");

        log.info("Atualizando partida id - {}, data - {}", id, partidaEntityRequest);
        var partidaUpdate = partidaRepository.findById(id);

        partidaUpdate.orElseThrow(() -> new EntityNotFoundException("Partida não encontrada para atualizar, o id informado não existe."));

        PartidaEntity entity = mapper.toEntity(partidaEntityRequest);
        entity.setId(id);

        partidaRepository.save(entity);
        return mapper.resquestToEntity(entity);
    }

    @Override
    public void deletePartida(Long id) throws Exception {
        log.info("Buscando partida para excluir partida id-{}", id);
        Optional<PartidaEntity> partidaById = partidaRepository.findById(id);

        if (partidaById.isEmpty()) {
            throw new EntityNotFoundException("Partida não encontrada para excluir, o id informado não existe.");
        }
        partidaRepository.deleteById(id);
    }
}