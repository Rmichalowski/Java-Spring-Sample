package com.michalowski.Projekt.api;

import com.michalowski.Projekt.domain.*;
import com.michalowski.Projekt.service.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class CpuController{
    private final CpuService cpuService;
    private final SpecificationService specificationService;
    private final CompatibleMobosService compatibleMobosService;

    public CpuController(CpuService cpuService, SpecificationService specificationService, CompatibleMobosService compatibleMobosService) {
        this.cpuService = cpuService;
        this.specificationService = specificationService;
        this.compatibleMobosService = compatibleMobosService;
    }

    @PostMapping("/api/cpu")
    public Cpu addCpu(@RequestBody Cpu cpu) {
        Cpu cpuToAdd = new Cpu(cpu.getName(), cpu.getSpecification(), cpu.getCompatibleMobos());
        return cpuService.addCpu(cpuToAdd);
    }

    @PutMapping("/api/cpu/{cpuId}")
    public Cpu updateCpu(@RequestBody Cpu cpu, @PathVariable long cpuId) {
        Cpu cpuToUpdate = new Cpu(cpu.getName(), cpu.getSpecification(), cpu.getCompatibleMobos());
        return cpuService.updateCpu(cpuToUpdate);
    }

    @DeleteMapping("/api/cpu/{cpuId}")
    public void deleteCpu(@PathVariable long cpuId) { cpuService.deleteCpu(cpuService.getCpu(cpuId)); }

    @GetMapping("/api/cpu")
    public Iterable<Cpu> allCpus() { return cpuService.allCpus(); }

    @GetMapping("/api/cpu/{cpuId}")
    public Cpu getCpu(@PathVariable long cpuId) { return cpuService.getCpu(cpuId); }



}
