package opc.task.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Grad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String naziv;
}
