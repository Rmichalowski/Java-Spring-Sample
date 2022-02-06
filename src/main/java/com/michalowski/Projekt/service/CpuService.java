package com.michalowski.Projekt.service;

import javax.transaction.Transactional;

import com.michalowski.Projekt.domain.CompatibleMobos;
import com.michalowski.Projekt.domain.Specification;
import com.michalowski.Projekt.domain.Cpu;
import com.michalowski.Projekt.repository.CompatibleMobosRepository;
import com.michalowski.Projekt.repository.SpecificationRepository;
import com.michalowski.Projekt.repository.CpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CpuService {
    private final CompatibleMobosRepository compatibleMobosRepository;
    private final SpecificationRepository specificationRepository;
    private final CpuRepository cpuRepository;

    @Autowired
    public CpuService(CompatibleMobosRepository compatibleMobosRepository, SpecificationRepository specificationRepository, CpuRepository cpuRepository) {
        this.compatibleMobosRepository = compatibleMobosRepository;
        this.specificationRepository = specificationRepository;
        this.cpuRepository = cpuRepository;
    }

    public Iterable<CompatibleMobos> allCompatibleMobos() {return compatibleMobosRepository.findAll();}

    public Specification getSpecification(Cpu cpu) {return specificationRepository.findById(cpu.getId()).orElse(null);}

    public Cpu getCpu(long id) {return cpuRepository.findById(id).orElse(null);}

    public Iterable<Cpu> allCpus() {return cpuRepository.findAll();}

    public CompatibleMobos addCompatibleMobos(CompatibleMobos compatibleMobos) {return compatibleMobosRepository.save(compatibleMobos);}

    public Cpu addCpu(Cpu cpu) {return cpuRepository.save(cpu);}

    public Specification addSpecification(Specification specification) {return specificationRepository.save(specification);}

    public Cpu updateCpu(Cpu cpu) {
        Cpu cpuToUpdate = cpuRepository.findById( cpu.getId() ).orElse(null);

        cpuToUpdate.setCompatibleMobos(cpu.getCompatibleMobos());
        cpuToUpdate.setSpecification(cpu.getSpecification());
        cpuToUpdate.setName(cpu.getName());

        return cpuRepository.save(cpuToUpdate);
    }

    public CompatibleMobos updateCompatibleMobos(CompatibleMobos compatibleMobos) {
        CompatibleMobos compatibleMobosToUpdate = compatibleMobosRepository.findById( compatibleMobos.getId() ).orElse(null);

        compatibleMobosToUpdate.setCpus(compatibleMobos.getCpus());
        compatibleMobosToUpdate.setManufacturer(compatibleMobos.getManufacturer());
        compatibleMobosToUpdate.setCpus(compatibleMobos.getCpus());

        return compatibleMobosRepository.save(compatibleMobosToUpdate);
    }

    public Specification updateSpecification(Specification specification) {
        Specification specificationToUpdate = specificationRepository.findById(specification.getId() ).orElse(null);

        specificationToUpdate.setCores(specification.getCores());
        specificationToUpdate.setFrequency(specification.getFrequency());
        specificationToUpdate.setTdp(specification.getTdp());

        return specificationRepository.save(specificationToUpdate);

    }

    public Cpu deleteCpu(Cpu cpu) {
        cpuRepository.deleteById(cpu.getId());
        return cpu;
    }

    public CompatibleMobos deleteCompatibleMobos(CompatibleMobos compatibleMobos) {
        compatibleMobosRepository.deleteById(compatibleMobos.getId());
        return compatibleMobos;
    }

    public Specification deleteSpecification(Specification specification) {
        specificationRepository.deleteById(specification.getId());
        return specification;
    }

    public void initializeDB() {


        CompatibleMobos compatibleMobos1 = new CompatibleMobos("extreme 3", "Asrock");
        CompatibleMobos compatibleMobos2 = new CompatibleMobos("extreme 2", "Asrock");
        CompatibleMobos compatibleMobos3 = new CompatibleMobos("H350", "Asus");
        CompatibleMobos compatibleMobos4 = new CompatibleMobos("gaming ", "Msi");
        CompatibleMobos compatibleMobos5 = new CompatibleMobos("Tuf", "Asus");
        CompatibleMobos compatibleMobos6 = new CompatibleMobos("H80", "Biostar");

        compatibleMobosRepository.save(compatibleMobos1);
        compatibleMobosRepository.save(compatibleMobos2);
        compatibleMobosRepository.save(compatibleMobos3);
        compatibleMobosRepository.save(compatibleMobos4);
        compatibleMobosRepository.save(compatibleMobos5);
        compatibleMobosRepository.save(compatibleMobos6);

        Specification specification1 = new Specification(3000,2,15);
        Specification specification2 = new Specification(3400,2,25);
        Specification specification3 = new Specification(3700,4,35);

        specificationRepository.save(specification1);
        specificationRepository.save(specification2);
        specificationRepository.save(specification3);

        Cpu cpu1 = new Cpu("i5-3120M",specification1, List.of(compatibleMobosRepository.findByName("extreme 2"),compatibleMobosRepository.findByName("H350"),compatibleMobosRepository.findByName("gaming")));
        Cpu cpu2 = new Cpu("i5-3210M",specification2,List.of(compatibleMobosRepository.findByName("extreme 2"),compatibleMobosRepository.findByName("Tuf"),compatibleMobosRepository.findByName("extreme 3")));
        Cpu cpu3 = new Cpu("i7-3720QM",specification3,List.of(compatibleMobosRepository.findByName("extreme 3"),compatibleMobosRepository.findByName("H80")));

        cpuRepository.save(cpu1);
        cpuRepository.save(cpu2);
        cpuRepository.save(cpu3);



    }



}
