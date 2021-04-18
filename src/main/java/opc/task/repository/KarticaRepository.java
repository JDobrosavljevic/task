package opc.task.repository;

import opc.task.model.Kartica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KarticaRepository extends JpaRepository<Kartica, Integer> {
    int countAllByKupacId(int kupacId);

    List<Kartica> findAllByKupacId(int kupacId);
}
