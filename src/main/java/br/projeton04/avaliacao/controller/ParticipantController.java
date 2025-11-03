package com.projeton04.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.projeton04.model.Participant;
import com.projeton04.service.ParticipantService;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @GetMapping
    public List<Participant> listarTodos() {
        return participantService.listarTodos();
    }

    @GetMapping("/{id}")
    public Participant buscarPorId(@PathVariable Long id) {
        return participantService.buscarPorId(id);
    }

    @GetMapping("/email")
    public Participant buscarPorEmail(@RequestParam String email) {
        return participantService.buscarPorEmail(email);
    }

    @PostMapping
    public Participant criar(@RequestBody Participant participant) {
        return participantService.salvar(participant);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        participantService.deletar(id);
    }
}
