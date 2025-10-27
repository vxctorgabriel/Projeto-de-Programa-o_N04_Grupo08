package br.projeton04.avaliacao.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.projeton04.avaliacao.model.Participante;
public interface ParticipanteRepository extends JpaRepository<Participante,String> {}
