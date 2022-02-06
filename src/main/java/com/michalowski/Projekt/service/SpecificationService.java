package com.michalowski.Projekt.service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.michalowski.Projekt.domain.Company;
import com.michalowski.Projekt.domain.Cpu;
import com.michalowski.Projekt.domain.Specification;
import com.michalowski.Projekt.repository.CompanyRepository;
import com.michalowski.Projekt.repository.CpuRepository;
import com.michalowski.Projekt.repository.SpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SpecificationService {
    private final SpecificationRepository specificationRepository;

    @Autowired
    public SpecificationService(SpecificationRepository specificationRepository) {
        this.specificationRepository = specificationRepository;
    }

    public Specification getSpecification(Cpu cpu) {return specificationRepository.findById(cpu.getId()).orElse(null);}

    public Specification addSpecification(Specification specification) {return specificationRepository.save(specification) ;}

    public Iterable<Specification> allSpecification() {return specificationRepository.findAll(); }

}
