package br.projeton04.avaliacao.dto;
public class FeedbackRequest {
    private String eventoId;
    private String autorId;
    private Integer avaliacao;
    private String comentario;
    // getters e setters
    public String getEventoId(){return eventoId;}
    public void setEventoId(String e){eventoId=e;}
    public String getAutorId(){return autorId;}
    public void setAutorId(String a){autorId=a;}
    public Integer getAvaliacao(){return avaliacao;}
    public void setAvaliacao(Integer av){avaliacao=av;}
    public String getComentario(){return comentario;}
    public void setComentario(String c){comentario=c;}
}
