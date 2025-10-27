package br.projeton04.avaliacao.dto;
import br.projeton04.avaliacao.model.Sentiment;
import java.time.LocalDateTime;

public class FeedbackResponse {
    private String id;
    private String eventoId;
    private String autorId;
    private Integer avaliacao;
    private String comentario;
    private Sentiment sentiment;
    private boolean denunciado;
    private LocalDateTime criadoEm;
    // getters e setters...
    public String getId(){return id;}
    public void setId(String id){this.id = id;}
    public String getEventoId(){return eventoId;}
    public void setEventoId(String e){eventoId = e;}
    public String getAutorId(){return autorId;}
    public void setAutorId(String a){autorId = a;}
    public Integer getAvaliacao(){return avaliacao;}
    public void setAvaliacao(Integer a){avaliacao = a;}
    public String getComentario(){return comentario;}
    public void setComentario(String c){comentario = c;}
    public Sentiment getSentiment(){return sentiment;}
    public void setSentiment(Sentiment s){ sentiment = s;}
    public boolean isDenunciado(){return denunciado;}
    public void setDenunciado(boolean d){denunciado = d;}
    public LocalDateTime getCriadoEm(){return criadoEm;}
    public void setCriadoEm(LocalDateTime t){criadoEm = t;}
}
