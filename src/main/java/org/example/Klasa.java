package org.example;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "KLASA", uniqueConstraints = {
        @UniqueConstraint(columnNames ={"rocznik","nazwa"})})
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Klasa.class)
public class Klasa {

    @Id @GeneratedValue(generator = "gen")
    @SequenceGenerator(name= "gen", sequenceName= "author_seq")
    @Column(name = "id")
    int id;
    @Column(name = "nazwa",length = 1)
    String nazwa; // A B C D mozliwe opcje
    @Column(name = "rocznik")
    int rocznik;
    @Column(name = "profil")
    String profil;

    @OneToMany(mappedBy = "klasa")
    private List<Uczen> uczniowie;

    @OneToOne(mappedBy = "klasa")
    Wychowawca wychowawca;

    public Klasa(){}

    public int getId(){
        return id;
    }
    public void setId(){
        this.id = id;
    }
    public String getNazwa(){
        return nazwa;
    }
    public void setNazwa(String nazwa){
        this.nazwa = nazwa;
    }
    public int getRocznik(){
        return rocznik;
    }
    public void setRocznik(int rocznik){
        this.rocznik = rocznik;
    }
    public String getProfil(){
        return profil;
    }
    public void setProfil(String profil){
        this.profil = profil;
    }

    public Wychowawca getWychowawca(){
        return wychowawca;
    }
    public void setWychowawca(Wychowawca wychowawca){
        this.wychowawca = wychowawca;
    }

    public List<Uczen> getUczniowie() {
        return uczniowie;
    }

    public void setUczniowie(List<Uczen> uczniowie) {
        this.uczniowie = uczniowie;
    }
}
