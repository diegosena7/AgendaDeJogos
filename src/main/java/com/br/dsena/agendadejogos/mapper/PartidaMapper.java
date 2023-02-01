package com.br.dsena.agendadejogos.mapper;

import com.br.dsena.agendadejogos.model.PartidaEntity;
import com.br.dsena.agendadejogos.model.PartidaRequestDTO;
import com.br.dsena.agendadejogos.model.PartidaResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PartidaMapper {

    public List<PartidaResponseDTO> resquestToEntity(List<PartidaEntity> partida){
        if (Objects.isNull(partida)) return new ArrayList<>();

        return partida.stream()
                .map(this::resquestToEntity)
                .collect(Collectors.toList());
    }

    public PartidaResponseDTO resquestToEntity(PartidaEntity entity) {

        if (Objects.isNull(entity)) return null;

        return  PartidaResponseDTO.builder()
                .id(entity.getId())
                .timeAdversario(entity.getTimeAdversario())
                .timeMandante(entity.getTimeMandante())
                .dataPartida(entity.getDataPartida())
                .build();
    }

    public PartidaEntity toEntity(PartidaRequestDTO request) {
        if (Objects.isNull(request)) {
            return null;
        } else {
            return PartidaEntity.builder()
                    .timeAdversario(request.getTimeAdversario())
                    .timeMandante(request.getTimeMandante())
                    .dataPartida(request.getDataPartida())
                    .build();
        }
    }
}
