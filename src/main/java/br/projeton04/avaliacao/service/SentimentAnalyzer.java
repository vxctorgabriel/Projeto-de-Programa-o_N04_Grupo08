package br.projeton04.avaliacao.service;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import br.projeton04.avaliacao.model.Sentiment;

public class SentimentAnalyzer {
    private static final Set<String> POS = new HashSet<>(Arrays.asList("bom","ótimo","otimo","excelente","maravilhoso","gostei","positivo","satisfeito","recomendo","boa"));
    private static final Set<String> NEG = new HashSet<>(Arrays.asList("ruim","péssimo","pessimo","horrível","horrivel","odiei","insatisfeito","terrível","terrivel","problema","lamentavel","decepcionante"));
    public Sentiment analyze(String text){
        if(text==null || text.trim().isEmpty()) return Sentiment.NEUTRAL;
        String[] toks = text.toLowerCase().replaceAll("[^a-z0-9ãâáàéêíóôõúç ]"," ").split("\\s+");
        int score=0;
        for(String t: toks){
            if(POS.contains(t)) score++;
            if(NEG.contains(t)) score--;
        }
        if(score>0) return Sentiment.POSITIVE;
        if(score<0) return Sentiment.NEGATIVE;
        return Sentiment.NEUTRAL;
    }
}
