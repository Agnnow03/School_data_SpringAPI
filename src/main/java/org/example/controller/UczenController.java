package org.example.controller;

import org.example.Uczen;
import org.example.services.UczenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UczenController {
    @Autowired
    private UczenService uczenService;
    @GetMapping(value = "/uczen", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Uczen> getUczen(){
        return uczenService.findAll();
    }

    @GetMapping(value = "/uczen/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Uczen getUczenById(@PathVariable("id") int id){
        Uczen uczen = uczenService.findById(id);
        if(uczen == null){
            throw new RuntimeException("Nie znaleziono ucznia z id "+id);
        }
        return uczen;
    }
    @PostMapping(value="/uczen")
    public Uczen save(@RequestBody Uczen uczen){
        return uczenService.save(uczen);
    }
    @PutMapping(value = "/uczen/{id}")
    public Uczen update(@PathVariable("id") int id, @RequestBody Uczen uczen){
        return uczenService.update(id, uczen);
    }
    @DeleteMapping(value = "/uczen/{id}")
    public void deleteById(@PathVariable("id") int id){
        Uczen uczen = uczenService.findById(id);
        if(uczen == null){
            throw new RuntimeException("Nie znaleziono ucznia z id "+id);
        }
        uczenService.deleteById(id);
    }
    @GetMapping(value = "/uczen/strona/{num}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Uczen> pageList(@PathVariable("num")Integer pageNum,@RequestParam(value="size",required = false) Optional<Integer> howManyOnPage){
        return uczenService.AllUczenPaging(pageNum,howManyOnPage.orElse(2));
    }
}
