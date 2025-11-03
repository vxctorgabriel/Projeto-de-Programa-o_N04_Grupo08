package com.projeton04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeton04.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
