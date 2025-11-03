package com.projeton04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeton04.model.Feedback;
import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByEventoId(Long eventoId);
    List<Feedback> findByParticipantId(Long participantId);
}
