package com.example.springtest4.controller;

import com.example.springtest4.dto.EntryDto;
import com.example.springtest4.model.Item;
import com.example.springtest4.model.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping("/")
    public String index(Model model) {
        List<Item> allItems = itemRepository.findAll();
        model.addAttribute("allItems", allItems);
        model.addAttribute("entryDto", new EntryDto());
        return "index";
    }

    @PostMapping("/save" )
    public String save(@ModelAttribute EntryDto entryDto) {

        return "index";
    }
}
