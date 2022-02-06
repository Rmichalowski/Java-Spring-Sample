package com.michalowski.Projekt.service;

import javax.transaction.Transactional;

import com.michalowski.Projekt.domain.CompatibleMobos;
import com.michalowski.Projekt.domain.Cpu;
import com.michalowski.Projekt.repository.CompatibleMobosRepository;
import com.michalowski.Projekt.repository.CpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CompatibleMobosService {

    private final CompatibleMobosRepository compatibleMobosRepository;
    private final CpuRepository cpuRepository;

    @Autowired
    public CompatibleMobosService(CompatibleMobosRepository compatibleMobosRepository, CpuRepository cpuRepository) {
        this.compatibleMobosRepository = compatibleMobosRepository;
        this.cpuRepository = cpuRepository;
    }

    public CompatibleMobos getCompatibleMobos(long id) { return compatibleMobosRepository.findById(id).orElse(null); }

    public CompatibleMobos addCompatibleMobos(CompatibleMobos compatibleMobos) {return compatibleMobosRepository.save(compatibleMobos);}

    public Cpu addCpu(Cpu cpu) {return cpuRepository.save(cpu);}

    public Iterable<CompatibleMobos> allCompatibleMobos() {return compatibleMobosRepository.findAll();}

    public Iterable<Cpu> allCpus() {return cpuRepository.findAll();}

    public CompatibleMobos updateCompatibleMobos(CompatibleMobos compatibleMobos) {
        CompatibleMobos compatibleMobosToUpdate = compatibleMobosRepository.findById( compatibleMobos.getId() ).orElse(null);

        compatibleMobosToUpdate.setCpus(compatibleMobos.getCpus());
        compatibleMobosToUpdate.setManufacturer(compatibleMobos.getManufacturer());
        compatibleMobosToUpdate.setCpus(compatibleMobos.getCpus());

        return compatibleMobosRepository.save(compatibleMobosToUpdate);
    }

    public Cpu updateCpu(Cpu cpu) {
        Cpu cpuToUpdate = cpuRepository.findById( cpu.getId() ).orElse(null);

        cpuToUpdate.setCompatibleMobos(cpu.getCompatibleMobos());
        cpuToUpdate.setSpecification(cpu.getSpecification());
        cpuToUpdate.setName(cpu.getName());

        return cpuRepository.save(cpuToUpdate);
    }

    public CompatibleMobos deleteCompatibleMobos(CompatibleMobos compatibleMobos) {
        compatibleMobosRepository.deleteById(compatibleMobos.getId());
        return compatibleMobos;
    }

    public Cpu deleteCpu(Cpu cpu) {
        cpuRepository.deleteById(cpu.getId());
        return cpu;
    }



}
