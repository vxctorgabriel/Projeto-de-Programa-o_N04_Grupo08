package br.projeton04.avaliacao.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="feedback", uniqueConstraints = @UniqueConstraint(columnNames = {"evento_id","autor_id"}))
public class Feedback {
    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne
    @JoinColumn(name="evento_id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name="autor_id")
    private Participante autor;

    private Integer avaliacao; // 1..5

    @Lob
    private String comentario;

    @Enumerated(EnumType.STRING)
    private Sentiment sentiment;

    private boolean denunciado = false;

    private LocalDateTime criadoEm = LocalDateTime.now();

    // getters e setters
    public String getId(){ return id; }
    public Evento getEvento(){ return evento; }
    public void setEvento(Evento e){ this.evento = e; }
    public Participante getAutor(){ return autor; }
    public void setAutor(Participante p){ this.autor = p; }
    public Integer getAvaliacao(){ return avaliacao; }
    public void setAvaliacao(Integer a){ this.avaliacao = a; }
    public String getComentario(){ return comentario; }
    public void setComentario(String c){ this.comentario = c; }
    public Sentiment getSentiment(){ return sentiment; }
    public void setSentiment(Sentiment s){ this.sentiment = s; }
    public boolean isDenunciado(){ return denunciado; }
    public void setDenunciado(boolean d){ this.denunciado = d; }
    public LocalDateTime getCriadoEm(){ return criadoEm; }
}
