package opc.task.repository;

import opc.task.model.Kupac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KupacRepository extends JpaRepository<Kupac, Integer> {
    List<Kupac> findAllByAktivan(boolean aktivan);
}
