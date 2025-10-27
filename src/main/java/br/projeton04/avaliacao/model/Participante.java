package br.projeton04.avaliacao.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Participante {
    @Id
    private String id = UUID.randomUUID().toString();
    private String nome;
    @Enumerated(EnumType.STRING)
    private ParticipantType tipo;

    public String getId(){ return id; }
    public String getNome(){ return nome; }
    public void setNome(String n){ nome = n; }
    public ParticipantType getTipo(){ return tipo; }
    public void setTipo(ParticipantType t){ tipo = t; }
}
