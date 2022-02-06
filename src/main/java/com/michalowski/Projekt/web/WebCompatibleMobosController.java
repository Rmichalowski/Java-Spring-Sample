package com.michalowski.Projekt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.michalowski.Projekt.domain.*;
import com.michalowski.Projekt.service.*;


import javax.validation.Valid;

@Controller
public class WebCompatibleMobosController {
    private final CompatibleMobosService compatibleMobosService;

    @Autowired
    public WebCompatibleMobosController(CompatibleMobosService compatibleMobosService) {
        this.compatibleMobosService = compatibleMobosService;
    }

    @GetMapping("/compatibleMobos/add")
    public String compatibleMobos(Model model) {
        model.addAttribute("compatibleMobos", new CompatibleMobos());
        return "compatibleMobos-add";
    }

    @PostMapping("/compatibleMobos/add")
    public String addNewcompatibleMobos(@ModelAttribute("compatibleMobos") @Valid CompatibleMobos compatibleMobos, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("Validation error found!");
            return "compatibleMobos-add";
        }
        compatibleMobosService.addCompatibleMobos( compatibleMobos);
        return "redirect:/cpu";
    }

}
