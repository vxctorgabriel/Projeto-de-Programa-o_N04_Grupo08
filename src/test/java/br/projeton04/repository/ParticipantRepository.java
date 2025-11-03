package com.projeton04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeton04.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Participant findByEmail(String email); // exemplo de busca por email
}
