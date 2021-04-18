package opc.task.service;

import opc.task.dto.ListaRezultataDTO;
import opc.task.dto.RezultatDTO;
import opc.task.model.Kartica;
import opc.task.model.KarticaDozvoljenGrad;
import opc.task.model.Kupac;
import opc.task.repository.GradRepository;
import opc.task.repository.KarticaDozvoljenGradRepository;
import opc.task.repository.KarticaRepository;
import opc.task.repository.KupacRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class KupacService {
    @Resource
    KupacRepository kupacRepository;
    @Resource
    KarticaRepository karticaRepository;
    @Resource
    GradRepository gradRepository;
    @Resource
    KarticaDozvoljenGradRepository karticaDozvoljenGradRepository;

    public ListaRezultataDTO trazi() {
        ListaRezultataDTO listaRezultataDTO = new ListaRezultataDTO();
        List<RezultatDTO> lista = new ArrayList<>();

        List<Kupac> listaKupaca = kupacRepository.findAll();
        for (Kupac k : listaKupaca) {
            RezultatDTO rezultatDTO = new RezultatDTO();
            rezultatDTO.setNazivKupca(k.getNaziv());
            rezultatDTO.setAktivan(k.isAktivan());
            rezultatDTO.setMaticniGrad(k.getGrad().getNaziv());
            rezultatDTO.setUkupanBrojKartica(vratiBrojKarticaZaKupce(k.getId()));
            rezultatDTO.setDozvoljeniGradovi(vratiDozvoljeneGradoveZaKarticeKupca(k.getId()));
            lista.add(rezultatDTO);
        }
        listaRezultataDTO.setListaRezultataDTO(lista);
        return listaRezultataDTO;
    }

    private List<String> vratiDozvoljeneGradoveZaKarticeKupca(int kupacId) {
        return gradRepository.vratiGradoveZaKarticeKupca(kupacId);
    }


    private int vratiBrojKarticaZaKupce(int kupacId) {
        return karticaRepository.countAllByKupacId(kupacId);
    }

    public ListaRezultataDTO akcija() {
        ListaRezultataDTO listaRezultataDTO = new ListaRezultataDTO();
        List<RezultatDTO> lista = new ArrayList<>();

        dodajMaticneGradove();

        List<Kupac> listaKupaca = kupacRepository.findAllByAktivan(true);
        for (Kupac k : listaKupaca) {
            RezultatDTO rezultatDTO = new RezultatDTO();
            rezultatDTO.setNazivKupca(k.getNaziv());
            rezultatDTO.setAktivan(k.isAktivan());
            rezultatDTO.setMaticniGrad(k.getGrad().getNaziv());
            rezultatDTO.setUkupanBrojKartica(vratiBrojKarticaZaKupce(k.getId()));
            rezultatDTO.setDozvoljeniGradovi(vratiDozvoljeneGradoveZaKarticeKupca(k.getId()));
            lista.add(rezultatDTO);
        }
        listaRezultataDTO.setListaRezultataDTO(lista);
        return listaRezultataDTO;
    }

    private void dodajMaticneGradove() {
        List<Kupac> listaKupaca = kupacRepository.findAll();

        for (Kupac k : listaKupaca) {
            int maticniGradId = k.getGrad().getId();
            List<Kartica> listaKartica = karticaRepository.findAllByKupacId(k.getId());

            for (Kartica kr : listaKartica) {
                boolean postojiMaticniGrad = karticaDozvoljenGradRepository.existsByKarticaIdAndGradId(kr.getId(), maticniGradId);
                if (!postojiMaticniGrad) {
                    KarticaDozvoljenGrad karticaDozvoljenGrad = new KarticaDozvoljenGrad();
                    karticaDozvoljenGrad.setKartica(kr);
                    karticaDozvoljenGrad.setGrad(k.getGrad());
                    karticaDozvoljenGradRepository.save(karticaDozvoljenGrad);
                }
            }
        }
    }

}
