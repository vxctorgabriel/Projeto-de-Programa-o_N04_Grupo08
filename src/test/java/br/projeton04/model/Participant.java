package com.projeton04.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    @ManyToOne
    private ParticipantType participantType;

    @OneToMany(mappedBy = "participant")
    private List<Feedback> feedbacks;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public ParticipantType getParticipantType() { return participantType; }
    public void setParticipantType(ParticipantType participantType) { this.participantType = participantType; }

    public List<Feedback> getFeedbacks() { return feedbacks; }
    public void setFeedbacks(List<Feedback> feedbacks) { this.feedbacks = feedbacks; }
}
