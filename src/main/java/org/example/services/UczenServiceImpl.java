package org.example.services;

import org.example.Uczen;
import org.example.repositories.UczenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UczenServiceImpl implements UczenService{
    @Autowired
    private UczenRepository uczenRepository;

    @Override
    public List<Uczen> findAll(){
        return uczenRepository.findAll();
    }

    @Override
    public Uczen findById(int id) {
        Optional<Uczen> uczen =  uczenRepository.findById(id);
        if(uczen.isEmpty()){
            throw new RuntimeException("Nie znalezniono ucznia z id "+id);
        }
        return uczen.get();
    }

    @Override
    public Uczen save(Uczen uczen) {
        return uczenRepository.save(uczen);
    }

    @Override
    public Uczen update(int id, Uczen uczen) {
        Optional<Uczen> optionalUczen = uczenRepository.findById(id);
        if(optionalUczen.isEmpty()){
            throw new RuntimeException("Nie znaleziono ucznia z id "+id);
        }
        Uczen updateUczen = optionalUczen.get();
        if(uczen.getImie() != null){
            updateUczen.setImie(uczen.getImie());
        }
        if(uczen.getNazwisko() != null){
            updateUczen.setNazwisko(uczen.getNazwisko());
        }
        if(uczen.getPesel() != null){
            updateUczen.setPesel(uczen.getPesel());
        }
        if(uczen.getKlasa()!=null){
            updateUczen.setKlasa(uczen.getKlasa());
        }

        return uczenRepository.save(updateUczen);
    }

    @Override
    public void deleteById(int id) {
        Optional<Uczen> uczen = uczenRepository.findById(id);
        if(uczen.isEmpty()){
            throw new RuntimeException("Nie znaleziono ucznia z id "+id);
        }
        uczenRepository.deleteById(id);
    }


    @Override
    public Iterable<Uczen> AllUczenPaging(Integer pageNum, Integer howManyOnPage) {
        return uczenRepository.findAll(PageRequest.of(pageNum,howManyOnPage));
    }
}
