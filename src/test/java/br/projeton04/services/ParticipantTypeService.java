package com.projeton04.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.projeton04.model.ParticipantType;
import com.projeton04.repository.ParticipantTypeRepository;

@Service
public class ParticipantTypeService {

    @Autowired
    private ParticipantTypeRepository participantTypeRepository;

    public List<ParticipantType> listarTodos() {
        return participantTypeRepository.findAll();
    }

    public ParticipantType salvar(ParticipantType type) {
        return participantTypeRepository.save(type);
    }

    public ParticipantType buscarPorId(Long id) {
        return participantTypeRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        participantTypeRepository.deleteById(id);
    }
}
