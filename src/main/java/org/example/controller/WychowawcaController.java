package org.example.controller;

import org.example.Wychowawca;
import org.example.services.WychowawcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class WychowawcaController {
    @Autowired
    private WychowawcaService wychowawcaService;
    @GetMapping(value = "/wychowawca", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Wychowawca> getWychowawca(){
        return wychowawcaService.findAll();
    }

    @GetMapping(value = "/wychowawca/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Wychowawca getWychowawcaById(@PathVariable("id") int id){
        Wychowawca wychowawca = wychowawcaService.findById(id);
        if(wychowawca == null){
            throw new RuntimeException("Nie znaleziono wychowawcy z id "+id);
        }
        return wychowawca;
    }
    @PostMapping(value="/wychowawca")
    public Wychowawca save(@RequestBody Wychowawca wychowawca){
        return wychowawcaService.save(wychowawca);
    }
    @PutMapping(value = "/wychowawca/{id}")
    public Wychowawca update(@PathVariable("id") int id, @RequestBody Wychowawca wychowawca){
        return wychowawcaService.update(id, wychowawca);
    }
    @DeleteMapping(value = "/wychowawca/{id}")
    public void deleteById(@PathVariable("id") int id){
        Wychowawca wychowawca = wychowawcaService.findById(id);
        if(wychowawca == null){
            throw new RuntimeException("Nie znaleziono wychowawcy z id "+id);
        }
        wychowawcaService.deleteById(id);
    }
}
