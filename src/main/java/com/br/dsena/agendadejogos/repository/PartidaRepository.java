package com.br.dsena.agendadejogos.repository;

import com.br.dsena.agendadejogos.model.PartidaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends JpaRepository<PartidaEntity, Long> {


}
