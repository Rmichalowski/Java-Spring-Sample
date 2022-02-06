package com.michalowski.Projekt.api;

import com.michalowski.Projekt.domain.*;
import com.michalowski.Projekt.service.*;
import org.springframework.web.bind.annotation.*;


@RestController
public class CompatibleMobosController {
    private final CompatibleMobosService compatibleMobosService;

    public CompatibleMobosController(CompatibleMobosService compatibleMobosService) {
        this.compatibleMobosService = compatibleMobosService;
    }

    @PostMapping("/api/compatibleMobos")
    public CompatibleMobos addCompatibleMobos(@RequestBody CompatibleMobos compatibleMobos) {
        CompatibleMobos compatibleMobosToAdd = new CompatibleMobos(compatibleMobos.getName(),compatibleMobos.getManufacturer());
        return compatibleMobosService.addCompatibleMobos(compatibleMobosToAdd);
    }

    @PutMapping("/api/compatibleMobos/{compatibleMobosId}")
    public CompatibleMobos updateCompatibleMobos(@RequestBody CompatibleMobos compatibleMobos, @PathVariable long compatibleMobosId) {
        CompatibleMobos compatibleMobosToUpdate = new CompatibleMobos(compatibleMobos.getName(),compatibleMobos.getManufacturer());
        return compatibleMobosService.updateCompatibleMobos(compatibleMobosToUpdate);
    }

    @DeleteMapping("/api/compatibleMobos/{compatibleMobosId}")
    public void deleteCompatibleMobos(@PathVariable long compatibleMobosId) { compatibleMobosService.deleteCompatibleMobos(compatibleMobosService.getCompatibleMobos(compatibleMobosId)); }

    @GetMapping("/api/compatibleMobos")
    public Iterable<CompatibleMobos> allCompatibleMobos() { return compatibleMobosService.allCompatibleMobos(); }

    @GetMapping("/api/compatibleMobos/{compatibleMobosId}")
    public CompatibleMobos getCompatibleMobos(@PathVariable long compatibleMobosId) { return compatibleMobosService.getCompatibleMobos(compatibleMobosId); }

}
