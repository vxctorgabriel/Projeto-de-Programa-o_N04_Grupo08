package com.projeton04.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.projeton04.model.Feedback;
import com.projeton04.service.FeedbackService;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public List<Feedback> listarTodos() {
        return feedbackService.listarTodos();
    }

    @GetMapping("/{id}")
    public Feedback buscarPorId(@PathVariable Long id) {
        return feedbackService.buscarPorId(id);
    }

    @GetMapping("/evento/{eventoId}")
    public List<Feedback> buscarPorEvento(@PathVariable Long eventoId) {
        return feedbackService.buscarPorEvento(eventoId);
    }

    @GetMapping("/participant/{participantId}")
    public List<Feedback> buscarPorParticipant(@PathVariable Long participantId) {
        return feedbackService.buscarPorParticipant(participantId);
    }

    @PostMapping
    public Feedback criar(@RequestBody Feedback feedback) {
        return feedbackService.salvar(feedback);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        feedbackService.deletar(id);
    }
}
