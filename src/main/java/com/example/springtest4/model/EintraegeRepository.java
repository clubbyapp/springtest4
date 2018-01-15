package com.example.springtest4.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EintraegeRepository extends JpaRepository<Eintraege, Long> {

    List<Eintraege> findByZeitpunktBetween(Date anfang, Date ende);
}
