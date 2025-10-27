package br.projeton04.avaliacao.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import br.projeton04.avaliacao.repository.EventoRepository;
import br.projeton04.avaliacao.repository.ParticipanteRepository;
import br.projeton04.avaliacao.repository.FeedbackRepository;
import br.projeton04.avaliacao.model.Evento;
import br.projeton04.avaliacao.model.Participante;
import br.projeton04.avaliacao.model.ParticipantType;
import br.projeton04.avaliacao.dto.FeedbackRequest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AvaliacaoServiceTest {

    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private ParticipanteRepository participanteRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private FeedbackService feedbackService;

    @Test
    public void criarEValidarMediaEFiltroEDenuncia() {
        Evento e = new Evento();
        e.setTitulo("Teste E");
        eventoRepository.save(e);

        Participante p = new Participante();
        p.setNome("João");
        p.setTipo(ParticipantType.PUBLICO);
        participanteRepository.save(p);

        FeedbackRequest req = new FeedbackRequest();
        req.setEventoId(e.getId());
        req.setAutorId(p.getId());
        req.setAvaliacao(5);
        req.setComentario("Ótimo evento, gostei muito");
        var resp = feedbackService.criarFeedback(req);
        assertEquals(5, resp.getAvaliacao());
        var avg = feedbackRepository.avgAvaliacaoByEvento(e.getId());
        assertEquals(5.0, avg);

        // tentar duplicar -> exceção
        assertThrows(IllegalStateException.class, () -> feedbackService.criarFeedback(req));

        // denúncia
        feedbackService.denunciar(resp.getId());
        var f = feedbackRepository.findById(resp.getId()).get();
        assertTrue(f.isDenunciado());
    }
}
