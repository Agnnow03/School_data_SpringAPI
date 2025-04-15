package org.example.services;

import org.example.Uczen;
import org.example.Zatrudnienie;

import java.util.List;

public interface ZatrudnienieService {
    List<Zatrudnienie> findAll();
    Zatrudnienie findById(int id);

    Zatrudnienie save(Zatrudnienie zatrudnienie);

    Zatrudnienie update(int id,Zatrudnienie zatrudnienie);

    void deleteById(int id);
}
