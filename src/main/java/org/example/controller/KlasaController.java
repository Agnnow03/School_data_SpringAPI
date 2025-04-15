package org.example.controller;

import org.example.Klasa;
import org.example.services.KlasaService;
import org.example.services.KlasaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KlasaController {
    @Autowired
    private KlasaService klasaService;
    @GetMapping(value = "/klasa", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Klasa> getKlasa(){
        return klasaService.findAll();
    }

    @GetMapping(value = "/klasa/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Klasa getKlasaById(@PathVariable("id") int id){
        Klasa klasa = klasaService.findById(id);
        if(klasa == null){
            throw new RuntimeException("Nie znaleziono klasy z id "+id);
        }
        return klasa;
    }
    @PostMapping(value="/klasa")
    public Klasa save(@RequestBody Klasa klasa){
        return klasaService.save(klasa);
    }
    @PutMapping(value = "/klasa/{id}")
    public Klasa update(@PathVariable("id") int id, @RequestBody Klasa klasa){
        return klasaService.update(id, klasa);
    }
    @DeleteMapping(value = "/klasa/{id}")
    public void deleteById(@PathVariable("id") int id){
        Klasa klasa = klasaService.findById(id);
        if(klasa == null){
            throw new RuntimeException("Nie znaleziono klasa z id "+id);
        }
        klasaService.deleteById(id);
    }
}
