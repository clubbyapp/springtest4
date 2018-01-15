package com.example.springtest4.controller;

import com.example.springtest4.dto.EntryDto;
import com.example.springtest4.model.Eintraege;
import com.example.springtest4.model.EintraegeRepository;
import com.example.springtest4.model.Item;
import com.example.springtest4.model.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    EintraegeRepository eintraegeRepository;

    @RequestMapping("/")
    public String index(Model model) {
        List<Item> allItems = itemRepository.findAll();
        model.addAttribute("allItems", allItems);
        model.addAttribute("entryDto", new EntryDto());

        Date aktuellerZeitpunkt = new Date();
        Date startOfDay = getStartOfDay(aktuellerZeitpunkt);
        Date endOfDay = getEndOfDay(aktuellerZeitpunkt);

        List<Eintraege> eintraege = eintraegeRepository.findByZeitpunktBetween(startOfDay, endOfDay);

        for (Eintraege eintrag : eintraege) {
            double kalorien = eintrag.getItem().getKalorienProEinheit() * eintrag.getMenge();
        }

        return "index";
    }

    @PostMapping("/save" )
    public String save(@ModelAttribute EntryDto entryDto) {
        Eintraege neuerEintrag = new Eintraege();
        Item item = itemRepository.findByName(entryDto.getName());
        neuerEintrag.setItem(item);
        neuerEintrag.setMenge(entryDto.getMenge());
        Date aktuellerZeitpunkt = new Date(); //der Konstruktor initialisiert die Variable direkt mit dem aktuellen Zeitstempel
        neuerEintrag.setZeitpunkt(aktuellerZeitpunkt);
        eintraegeRepository.save(neuerEintrag);
        return "index";
    }


    //Hilfsfunktionen zur Datumsberechnung (in eigene Klasse auslagern)
    //LocalDateTime läuft erst an Java 8
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return localDateTimeToDate(endOfDay);
    }

    public static Date getStartOfDay(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return localDateTimeToDate(startOfDay);
    }

    private static Date localDateTimeToDate(LocalDateTime startOfDay) {
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    private static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
    }
}
