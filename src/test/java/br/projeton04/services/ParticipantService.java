package com.projeton04.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.projeton04.model.Participant;
import com.projeton04.repository.ParticipantRepository;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public List<Participant> listarTodos() {
        return participantRepository.findAll();
    }

    public Participant salvar(Participant participant) {
        return participantRepository.save(participant);
    }

    public Participant buscarPorId(Long id) {
        return participantRepository.findById(id).orElse(null);
    }

    public Participant buscarPorEmail(String email) {
        return participantRepository.findByEmail(email);
    }

    public void deletar(Long id) {
        participantRepository.deleteById(id);
    }
}
