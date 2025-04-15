package org.example.services;

import org.example.Uczen;
import org.example.Wychowawca;

import java.util.List;

public interface WychowawcaService {
    List<Wychowawca> findAll();
    Wychowawca findById(int id);

    Wychowawca save(Wychowawca wychowawca);

    Wychowawca update(int id,Wychowawca wychowawca);

    void deleteById(int id);
}
