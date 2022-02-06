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
public class WebCpuController {
    private final CpuService cpuService;
    private final SpecificationService specificationService;
    private final CompatibleMobosService compatibleMobosService;

    @Autowired
    public WebCpuController(CpuService cpuService, SpecificationService specificationService, CompatibleMobosService compatibleMobosService) {
        this.cpuService = cpuService;
        this.specificationService = specificationService;
        this.compatibleMobosService = compatibleMobosService;
    }

    @GetMapping("/cpu")
    public String cpus(Model model) {
        model.addAttribute("allCpusFromDB", cpuService.allCpus());
        return "cpu-all";
    }

    @GetMapping("/cpu/add")
    public String addNewCpu(Model model){
        model.addAttribute("allSpecification", specificationService.allSpecification());
        model.addAttribute("allCompatibleMobos", compatibleMobosService.allCompatibleMobos());
        model.addAttribute("cpu" , new Cpu());
        return "cpu-add";
    }

    @PostMapping("/cpu")
    public String addNewCpu(@ModelAttribute("cpu") @Valid Cpu cpu, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("Validation error found!");
            return "redirect:/cpu/add";
        }
        cpuService.addCpu( cpu);
        return "redirect:/cpu";
    }

    @GetMapping("/cpu/delete/{id}")
    public String deleteCpu(@PathVariable("id") long id, Model model) {
        cpuService.deleteCpu(cpuService.getCpu(id));
        model.addAttribute("allCpusFromDB",cpuService.allCpus());

        return "redirect:/cpu";
    }

    @GetMapping("/cpu/update/{id}")
    public String updateCpu(@PathVariable("id") long id, Model model){
        Cpu cpuToUpdate = cpuService.getCpu(id);
        model.addAttribute("cpuToUpdate",cpuToUpdate);
        model.addAttribute("allSpecification", specificationService.allSpecification());
        model.addAttribute("allCompatibleMobos", compatibleMobosService.allCompatibleMobos());
        return "cpu-update";
    }

    @PostMapping("/cpu/update/{id}")
    public String updateCpu(@PathVariable("id") String id,@ModelAttribute("cpuToUpdate") @Valid Cpu cpuToUpdate,BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            System.out.println("Validation error found!");
            return "redirect:/cpu/update";
        }
        cpuService.updateCpu(cpuToUpdate);
        //model.addAttribute("allCpusFromDB",cpuService.allCpus());
        return "redirect:/cpu";
    }

}
