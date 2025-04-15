package org.example.services;

import org.example.Wychowawca;
import org.example.repositories.WychowawcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WychowawcaServiceImpl implements WychowawcaService{

    @Autowired
    private WychowawcaRepository wychowawcaRepository;

    @Override
    public List<Wychowawca> findAll(){
        return wychowawcaRepository.findAll();
    }

    @Override
    public Wychowawca findById(int id) {
        Optional<Wychowawca> wychowawca =  wychowawcaRepository.findById(id);
        if(wychowawca.isEmpty()){
            throw new RuntimeException("Nie znalezniono wychowawcy z id "+id);
        }
        return wychowawca.get();
    }

    @Override
    public Wychowawca save(Wychowawca wychowawca) {
        return wychowawcaRepository.save(wychowawca);
    }

    @Override
    public Wychowawca update(int id, Wychowawca wychowawca) {
        Optional<Wychowawca> optionalWychowawca = wychowawcaRepository.findById(id);
        if(optionalWychowawca.isEmpty()){
            throw new RuntimeException("Nie znaleziono wychowawcy z id "+id);
        }
        Wychowawca updateWychowawca = optionalWychowawca.get();
        if(wychowawca.getImie() != null){
            updateWychowawca.setImie(wychowawca.getImie());
        }
        if(wychowawca.getNazwisko() != null){
            updateWychowawca.setNazwisko(wychowawca.getNazwisko());
        }
        if(wychowawca.getPesel() != null){
            updateWychowawca.setPesel(wychowawca.getPesel());
        }
        if(wychowawca.getZatrudnienie()!=null){
            updateWychowawca.setZatrudnienie(wychowawca.getZatrudnienie());
        }
        if(wychowawca.getKlasa()!=null){
            updateWychowawca.setKlasa(wychowawca.getKlasa());
        }
        return wychowawcaRepository.save(updateWychowawca);
    }

    @Override
    public void deleteById(int id) {
        Optional<Wychowawca> wychowawca = wychowawcaRepository.findById(id);
        if(wychowawca.isEmpty()){
            throw new RuntimeException("Nie znaleziono wychowawcy z id "+id);
        }
        wychowawcaRepository.deleteById(id);
    }


}
