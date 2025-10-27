package br.projeton04.avaliacao.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.projeton04.avaliacao.model.Feedback;
import br.projeton04.avaliacao.model.ParticipantType;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FeedbackRepository extends JpaRepository<Feedback,String> {
    List<Feedback> findByEventoId(String eventoId);
    @Query("select f from Feedback f where f.evento.id = :eventoId and f.autor.tipo = :pt")
    List<Feedback> findByEventoIdAndParticipantType(@Param("eventoId") String eventoId, @Param("pt") ParticipantType pt);
    @Query("select avg(f.avaliacao) from Feedback f where f.evento.id = :eventoId and f.avaliacao is not null")
    Double avgAvaliacaoByEvento(@Param("eventoId") String eventoId);
    boolean existsByEventoIdAndAutorId(String eventoId, String autorId);
}
