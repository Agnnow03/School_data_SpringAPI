package org.example.services;

import org.example.Klasa;
import org.example.Uczen;

import java.util.List;

public interface UczenService {
    List<Uczen> findAll();
    Uczen findById(int id);

    Uczen save(Uczen uczen);

    Uczen update(int id,Uczen uczen);

    void deleteById(int id);

    Iterable<Uczen> AllUczenPaging(Integer pageNum, Integer howManyOnPage);
}
