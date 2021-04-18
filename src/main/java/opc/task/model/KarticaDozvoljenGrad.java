package opc.task.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class KarticaDozvoljenGrad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    @JoinColumn(name="kartica_id")
    Kartica kartica;
    @ManyToOne
    @JoinColumn(name="grad_id")
    Grad grad;
}
