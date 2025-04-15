package org.example.controller;

import org.example.Zatrudnienie;
import org.example.services.ZatrudnienieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ZatrudnienieController {
    @Autowired
    private ZatrudnienieService zatrudnienieService;
    @GetMapping(value = "/zatrudnienie", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Zatrudnienie> getZatrudnienie(){
        return zatrudnienieService.findAll();
    }

    @GetMapping(value = "/zatrudnienie/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Zatrudnienie getZatrudnienieById(@PathVariable("id") int id){
        Zatrudnienie zatrudnienie = zatrudnienieService.findById(id);
        if(zatrudnienie == null){
            throw new RuntimeException("Nie znaleziono zatrudnienia z id "+id);
        }
        return zatrudnienie;
    }
    @PostMapping(value="/zatrudnienie")
    public Zatrudnienie save(@RequestBody Zatrudnienie zatrudnienie){
        return zatrudnienieService.save(zatrudnienie);
    }
    @PutMapping(value = "/zatrudnienie/{id}")
    public Zatrudnienie update(@PathVariable("id") int id, @RequestBody Zatrudnienie zatrudnienie){
        return zatrudnienieService.update(id, zatrudnienie);
    }
    @DeleteMapping(value = "/zatrudnienie/{id}")
    public void deleteById(@PathVariable("id") int id){
        Zatrudnienie zatrudnienie = zatrudnienieService.findById(id);
        if(zatrudnienie == null){
            throw new RuntimeException("Nie znaleziono zatrudnienia z id "+id);
        }
        zatrudnienieService.deleteById(id);
    }
}
