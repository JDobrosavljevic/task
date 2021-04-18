package opc.task.repository;

import opc.task.model.Grad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradRepository extends JpaRepository<Grad, Integer> {
    @Query(value="SELECT g.naziv \n" +
            "FROM grad g \n" +
            "JOIN kartica_dozvoljen_grad kdg ON g.id=kdg.grad_id \n" +
            "JOIN kartica k ON kdg.kartica_id=k.id\n" +
            "JOIN kupac ku ON k.kupac_id=ku.id \n" +
            "WHERE ku.id=:kupacId", nativeQuery = true)
    List<String> vratiGradoveZaKarticeKupca(int kupacId);


}
