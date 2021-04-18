package opc.task.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Kartica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(unique = true)
    int broj_kartice;
    @ManyToOne
    @JoinColumn(name="kupac_id")
    Kupac kupac;
}
