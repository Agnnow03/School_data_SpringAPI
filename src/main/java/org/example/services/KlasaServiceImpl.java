package org.example.services;

import org.example.Klasa;
import org.example.repositories.KlasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KlasaServiceImpl implements KlasaService {

    @Autowired
    private KlasaRepository klasaRepository;

    @Override
    public List<Klasa> findAll(){
        return klasaRepository.findAll();
    }

    @Override
    public Klasa findById(int id) {
        Optional<Klasa> klasa =  klasaRepository.findById(id);
        if(klasa.isEmpty()){
            throw new RuntimeException("Nie znalezniono klasy z id "+id);
        }
        return klasa.get();
    }

    @Override
    public Klasa save(Klasa klasa) {
        return klasaRepository.save(klasa);
    }

    @Override
    public Klasa update(int id, Klasa klasa) {
        Optional<Klasa> optionalKlasa = klasaRepository.findById(id);
        if(optionalKlasa.isEmpty()){
            throw new RuntimeException("Nie znaleziono klasy z id "+id);
        }
        Klasa updateKlasa = optionalKlasa.get();
        if(klasa.getNazwa() != null){
            updateKlasa.setNazwa(klasa.getNazwa());
        }
        if(klasa.getRocznik() != 0){
            updateKlasa.setRocznik(klasa.getRocznik());
        }
        if(klasa.getProfil() != null){
            updateKlasa.setProfil(klasa.getProfil());
        }
        if(klasa.getWychowawca()!=null){
            updateKlasa.setWychowawca(klasa.getWychowawca());
        }
        if(klasa.getUczniowie()!=null){
            updateKlasa.setUczniowie(klasa.getUczniowie());
        }
        return klasaRepository.save(updateKlasa);
    }

    @Override
    public void deleteById(int id) {
        Optional<Klasa> klasa = klasaRepository.findById(id);
        if(klasa.isEmpty()){
            throw new RuntimeException("Nie znaleziono klasy z id "+id);
        }
        klasaRepository.deleteById(id);
    }


}
