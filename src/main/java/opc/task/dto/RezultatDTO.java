package opc.task.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class RezultatDTO {
    String nazivKupca;
    boolean aktivan;
    String maticniGrad;
    int ukupanBrojKartica;
    List<String> dozvoljeniGradovi;
}
