package org.example.services;

import org.example.Klasa;

import java.util.List;

public interface KlasaService {
    List<Klasa> findAll();
    Klasa findById(int id);

    Klasa save(Klasa klasa);

    Klasa update(int id,Klasa klasa);

    void deleteById(int id);
}

