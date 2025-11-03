package com.projeton04.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.projeton04.model.Feedback;
import com.projeton04.repository.FeedbackRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> listarTodos() {
        return feedbackRepository.findAll();
    }

    public Feedback salvar(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Feedback buscarPorId(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    public List<Feedback> buscarPorEvento(Long eventoId) {
        return feedbackRepository.findByEventoId(eventoId);
    }

    public List<Feedback> buscarPorParticipant(Long participantId) {
        return feedbackRepository.findByParticipantId(participantId);
    }

    public void deletar(Long id) {
        feedbackRepository.deleteById(id);
    }
}
