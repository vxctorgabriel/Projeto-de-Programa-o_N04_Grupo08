package br.projeton04.avaliacao.model;

public class Participante {
    private final String id;
    private final String nome;

    public Participante(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
}
