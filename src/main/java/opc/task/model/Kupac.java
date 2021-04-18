package opc.task.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Kupac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String naziv;
    @ManyToOne
    @JoinColumn(name="grad_id")
    Grad grad;
    boolean aktivan;
}
