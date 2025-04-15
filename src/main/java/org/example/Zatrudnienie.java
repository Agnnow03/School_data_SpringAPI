package org.example;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ZATRUDNIENIE",uniqueConstraints = {
        @UniqueConstraint(columnNames ={"wychowawca","data"})})
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Zatrudnienie.class)
public class Zatrudnienie {
    //joda time zatrudnienie

    @Id @GeneratedValue(generator = "gen")
    @SequenceGenerator(name= "gen", sequenceName= "author_seq")
    int id;
    @Column(name="pensja")
    int pensja;

    @Column(name = "data")//joda time
    DateTime data;

    @OneToOne
    @JoinColumn(name = "wychowawca",nullable = false)
    Wychowawca wychowawca;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getPensja(){
        return pensja;
    }
    public void setPensja(int pensja){
        this.pensja = pensja;
    }
    public DateTime getData(){
        return data;
    }
    public void setData(DateTime data){
        this.data = data;
    }
    //klucz obcy id wychowawcy?
    public Wychowawca getWychowawca(){
        return wychowawca;
    }
    public void setWychowawca(Wychowawca wychowawca){
        this.wychowawca = wychowawca;
    }
    public Zatrudnienie(){}

}
