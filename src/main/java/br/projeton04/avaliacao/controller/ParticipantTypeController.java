package com.projeton04.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.projeton04.model.ParticipantType;
import com.projeton04.service.ParticipantTypeService;

@RestController
@RequestMapping("/participant-types")
public class ParticipantTypeController {

    @Autowired
    private ParticipantTypeService participantTypeService;

    @GetMapping
    public List<ParticipantType> listarTodos() {
        return participantTypeService.listarTodos();
    }

    @GetMapping("/{id}")
    public ParticipantType buscarPorId(@PathVariable Long id) {
        return participantTypeService.buscarPorId(id);
    }

    @PostMapping
    public ParticipantType criar(@RequestBody ParticipantType type) {
        return participantTypeService.salvar(type);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        participantTypeService.deletar(id);
    }
}
