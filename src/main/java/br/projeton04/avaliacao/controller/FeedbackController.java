package br.projeton04.avaliacao.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import br.projeton04.avaliacao.service.FeedbackService;
import br.projeton04.avaliacao.dto.FeedbackRequest;
import br.projeton04.avaliacao.dto.FeedbackResponse;
import br.projeton04.avaliacao.dto.ReportResponse;
import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    @PostMapping
    public ResponseEntity<FeedbackResponse> criar(@RequestBody FeedbackRequest req){
        FeedbackResponse resp = service.criarFeedback(req);
        return ResponseEntity.status(201).body(resp);
    }

    @GetMapping("/evento/{eventoId}")
    public ResponseEntity<List<FeedbackResponse>> listar(@PathVariable String eventoId, @RequestParam(required=false) String tipoParticipante){
        List<FeedbackResponse> list = service.listarFeedbacks(eventoId, tipoParticipante);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/{id}/denunciar")
    public ResponseEntity<Void> denunciar(@PathVariable String id){
        service.denunciar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/evento/{eventoId}/relatorio")
    public ResponseEntity<ReportResponse> relatorio(@PathVariable String eventoId){
        ReportResponse r = service.relatorioSatisfacao(eventoId);
        return ResponseEntity.ok(r);
    }
}
