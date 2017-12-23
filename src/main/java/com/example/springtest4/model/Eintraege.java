package com.example.springtest4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Eintraege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int item_id;
    private int einheit;
    private Date zeitpunkt;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getEinheit() {
        return einheit;
    }

    public void setEinheit(int einheit) {
        this.einheit = einheit;
    }

    public Date getZeitpunkt() {
        return zeitpunkt;
    }

    public void setZeitpunkt(Date zeitpunkt) {
        this.zeitpunkt = zeitpunkt;
    }


}
