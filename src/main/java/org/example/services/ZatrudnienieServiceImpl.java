package org.example.services;

import org.example.Zatrudnienie;
import org.example.repositories.ZatrudnienieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZatrudnienieServiceImpl implements ZatrudnienieService{

    @Autowired
    private ZatrudnienieRepository zatrudnienieRepository;

    @Override
    public List<Zatrudnienie> findAll(){
        return zatrudnienieRepository.findAll();
    }

    @Override
    public Zatrudnienie findById(int id) {
        Optional<Zatrudnienie> zatrudnienie =  zatrudnienieRepository.findById(id);
        if(zatrudnienie.isEmpty()){
            throw new RuntimeException("Nie znalezniono zatrudnienia z id "+id);
        }
        return zatrudnienie.get();
    }

    @Override
    public Zatrudnienie save(Zatrudnienie zatrudnienie) {
        return zatrudnienieRepository.save(zatrudnienie);
    }

    @Override
    public Zatrudnienie update(int id, Zatrudnienie zatrudnienie) {
        Optional<Zatrudnienie> optionalZatrudnienie = zatrudnienieRepository.findById(id);
        if(optionalZatrudnienie.isEmpty()){
            throw new RuntimeException("Nie znaleziono zatrudnienia z id "+id);
        }
        Zatrudnienie updateZatrudnienie = optionalZatrudnienie.get();
        if(zatrudnienie.getData() != null){
            updateZatrudnienie.setData(zatrudnienie.getData());
        }
        if(zatrudnienie.getWychowawca() != null){
            updateZatrudnienie.setWychowawca(zatrudnienie.getWychowawca());
        }
        if(zatrudnienie.getPensja() != 0){
            updateZatrudnienie.setPensja(zatrudnienie.getPensja());
        }

        return zatrudnienieRepository.save(updateZatrudnienie);
    }

    @Override
    public void deleteById(int id) {
        Optional<Zatrudnienie> zatrudnienie = zatrudnienieRepository.findById(id);
        if(zatrudnienie.isEmpty()){
            throw new RuntimeException("Nie znaleziono zatrudnienia z id "+id);
        }
        zatrudnienieRepository.deleteById(id);
    }

}
