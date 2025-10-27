package br.projeton04.avaliacao.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import br.projeton04.avaliacao.repository.FeedbackRepository;
import br.projeton04.avaliacao.repository.EventoRepository;
import br.projeton04.avaliacao.repository.ParticipanteRepository;
import br.projeton04.avaliacao.model.Evento;
import br.projeton04.avaliacao.model.Participante;
import br.projeton04.avaliacao.model.Feedback;
import br.projeton04.avaliacao.model.Sentiment;
import br.projeton04.avaliacao.dto.FeedbackRequest;
import br.projeton04.avaliacao.dto.FeedbackResponse;
import br.projeton04.avaliacao.dto.ReportResponse;

import java.util.List;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private ParticipanteRepository participanteRepository;

    private final SentimentAnalyzer analyzer = new SentimentAnalyzer();

    public FeedbackResponse criarFeedback(FeedbackRequest req){
        if(!eventoRepository.existsById(req.getEventoId())) throw new IllegalArgumentException("evento.nao.encontrado");
        if(!participanteRepository.existsById(req.getAutorId())) throw new IllegalArgumentException("autor.nao.encontrado");
        if(feedbackRepository.existsByEventoIdAndAutorId(req.getEventoId(), req.getAutorId())) throw new IllegalStateException("feedback.ja.existe");

        Evento evento = eventoRepository.findById(req.getEventoId()).get();
        Participante autor = participanteRepository.findById(req.getAutorId()).get();

        Feedback f = new Feedback();
        f.setEvento(evento);
        f.setAutor(autor);
        f.setAvaliacao(req.getAvaliacao());
        f.setComentario(req.getComentario());
        Sentiment s = analyzer.analyze(req.getComentario());
        f.setSentiment(s);
        f.setDenunciado(false);
        Feedback saved = feedbackRepository.save(f);
        return toResponse(saved);
    }

    public List<FeedbackResponse> listarFeedbacks(String eventoId, String tipoParticipante){
        if(tipoParticipante == null || tipoParticipante.isBlank()){
            return feedbackRepository.findByEventoId(eventoId).stream().map(this::toResponse).collect(Collectors.toList());
        }
        return feedbackRepository.findByEventoIdAndParticipantType(eventoId, br.projeton04.avaliacao.model.ParticipantType.valueOf(tipoParticipante)).stream().map(this::toResponse).collect(Collectors.toList());
    }

    public void denunciar(String feedbackId){
        Feedback f = feedbackRepository.findById(feedbackId).orElseThrow(()-> new IllegalArgumentException("feedback.nao.encontrado"));
        f.setDenunciado(true);
        feedbackRepository.save(f);
    }

    public ReportResponse relatorioSatisfacao(String eventoId){
        Double avg = feedbackRepository.avgAvaliacaoByEvento(eventoId);
        List<Feedback> all = feedbackRepository.findByEventoId(eventoId);
        long total = all.size();
        Map<String,Long> counts = new HashMap<>();
        counts.put("POSITIVE", all.stream().filter(x->x.getSentiment()==Sentiment.POSITIVE).count());
        counts.put("NEUTRAL", all.stream().filter(x->x.getSentiment()==Sentiment.NEUTRAL).count());
        counts.put("NEGATIVE", all.stream().filter(x->x.getSentiment()==Sentiment.NEGATIVE).count());
        ReportResponse r = new ReportResponse();
        r.setEventoId(eventoId);
        r.setMediaAvaliacao(avg == null ? 0.0 : avg);
        r.setTotalFeedbacks(total);
        r.setSentimentCounts(counts);
        return r;
    }

    private FeedbackResponse toResponse(Feedback f){
        FeedbackResponse r = new FeedbackResponse();
        r.setId(f.getId());
        r.setEventoId(f.getEvento().getId());
        r.setAutorId(f.getAutor().getId());
        r.setAvaliacao(f.getAvaliacao());
        r.setComentario(f.getComentario());
        r.setSentiment(f.getSentiment());
        r.setDenunciado(f.isDenunciado());
        r.setCriadoEm(f.getCriadoEm());
        return r;
    }
}
