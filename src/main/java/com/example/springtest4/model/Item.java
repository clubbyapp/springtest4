package com.example.springtest4.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String info;
    private double kalorienProEinheit;
    private int typId;
    @OneToMany(mappedBy = "item")
    private Set<Eintraege> eintraege;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getKalorienProEinheit() {
        return kalorienProEinheit;
    }

    public void setKalorienProEinheit(double kalorienProEinheit) {
        this.kalorienProEinheit = kalorienProEinheit;
    }

    public int getTypId() {
        return typId;
    }

    public void setTypId(int typId) {
        this.typId = typId;
    }

    public Set<Eintraege> getEintraege() {
        return eintraege;
    }

    public void setEintraege(Set<Eintraege> eintraege) {
        this.eintraege = eintraege;
    }
}
