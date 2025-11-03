package com.projeton04.model;

import org.springframework.data.jpa.repository.JpaRepository;
import com.seuprojeto.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}