package com.example.springtest4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String info;
    private int einheit;
    private double kalorienProEinheit;
    private int typ_id;


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

    public int getEinheit() {
        return einheit;
    }

    public void setEinheit(int einheit) {
        this.einheit = einheit;
    }

    public double getKalorienProEinheit() {
        return kalorienProEinheit;
    }

    public void setKalorienProEinheit(double kalorienProEinheit) {
        this.kalorienProEinheit = kalorienProEinheit;
    }

    public int getTyp_id() {
        return typ_id;
    }

    public void setTyp_id(int typ_id) {
        this.typ_id = typ_id;
    }


}
