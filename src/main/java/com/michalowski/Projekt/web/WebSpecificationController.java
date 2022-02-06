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
public class WebSpecificationController {
    private final SpecificationService specificationService;

    @Autowired
    public WebSpecificationController(SpecificationService specificationService) {
        this.specificationService = specificationService;
    }

    @GetMapping("/specification/add")
    public String specification(Model model) {
        model.addAttribute("specification", new Specification());
        return "specification-add";
    }

    @PostMapping("/specification/add")
    public String addNewCpu(@ModelAttribute("specification") @Valid Specification specification, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("Validation error found!");
            return "specification-add";
        }
        specificationService.addSpecification( specification);
        return "redirect:/cpu";
    }

}
