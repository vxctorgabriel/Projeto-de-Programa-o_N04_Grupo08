package br.projeton04.avaliacao.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Evento {
    @Id
    private String id = UUID.randomUUID().toString();
    private String titulo;
    private String descricao;

    public String getId(){ return id; }
    public String getTitulo(){ return titulo; }
    public void setTitulo(String titulo){ this.titulo = titulo; }
    public String getDescricao(){ return descricao; }
    public void setDescricao(String descricao){ this.descricao = descricao; }
}
