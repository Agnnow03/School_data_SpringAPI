package org.example;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "UCZEN")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Uczen.class)
public class Uczen {

@Id @GeneratedValue
int id;

@Column(name="imie")
String imie;

@Column(name="nazwisko")
String nazwisko;

@Column(name="pesel",nullable=false,unique = true)
String pesel;

@ManyToOne
@JoinColumn(name = "klasa")
private Klasa klasa;

public int getId(){
    return id;
}
public void setId(int id){
    this.id = id;
}
public String getImie(){
    return imie;
}
public void setImie(String imie){
    this.imie = imie;
}
public String getNazwisko(){
    return nazwisko;
}
public void setNazwisko(String nazwisko){
    this.nazwisko = nazwisko;
}
public String getPesel(){
    return pesel;
}
public void setPesel(String pesel){
    this.pesel = pesel;
}

public Klasa getKlasa(){
    return klasa;
}
public void setKlasa(Klasa klasa){
    this.klasa = klasa;
}
public Uczen(){}
}
