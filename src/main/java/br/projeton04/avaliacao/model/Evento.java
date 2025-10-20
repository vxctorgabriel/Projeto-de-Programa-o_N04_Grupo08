package br.projeton04.avaliacao.model;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private final String id;
    private final String titulo;
    private final List<String> avaliacaoIds = new ArrayList<>();

    public Evento(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
}
