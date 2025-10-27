package br.projeton04.avaliacao.dto;
import java.util.Map;
public class ReportResponse {
    private String eventoId;
    private Double mediaAvaliacao;
    private Long totalFeedbacks;
    private Map<String,Long> sentimentCounts;
    // getters e setters...
    public String getEventoId(){return eventoId;}
    public void setEventoId(String e){eventoId=e;}
    public Double getMediaAvaliacao(){return mediaAvaliacao;}
    public void setMediaAvaliacao(Double m){mediaAvaliacao=m;}
    public Long getTotalFeedbacks(){return totalFeedbacks;}
    public void setTotalFeedbacks(Long t){totalFeedbacks=t;}
    public Map<String,Long> getSentimentCounts(){return sentimentCounts;}
    public void setSentimentCounts(Map<String,Long> m){sentimentCounts=m;}
}
