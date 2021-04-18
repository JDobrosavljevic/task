package opc.task.repository;

import opc.task.model.KarticaDozvoljenGrad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KarticaDozvoljenGradRepository extends JpaRepository<KarticaDozvoljenGrad, Integer> {
    boolean existsByKarticaIdAndGradId(int karticaId, int gradId);
}
