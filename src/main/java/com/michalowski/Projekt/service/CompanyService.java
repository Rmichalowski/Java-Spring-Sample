package com.michalowski.Projekt.service;

import javax.transaction.Transactional;
import java.util.Optional;

import com.michalowski.Projekt.domain.Company;
import com.michalowski.Projekt.domain.Cpu;
import com.michalowski.Projekt.repository.CompanyRepository;
import com.michalowski.Projekt.repository.CpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CpuRepository cpuRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, CpuRepository cpuRepository) {
        this.companyRepository = companyRepository;
        this.cpuRepository = cpuRepository;
    }

    public Optional<Company> getCompany(long id) { return companyRepository.findById(id);}

    public Optional<Cpu> getCpu(long id) {return cpuRepository.findById(id);}

    public Iterable<Company> allCompanies() {return companyRepository.findAll();}

    public Iterable<Cpu> allCpus() {return cpuRepository.findAll();}

    public Company addCompany(Company company) {return companyRepository.save(company);}

    public Cpu addCpu(Cpu cpu) {return cpuRepository.save(cpu);}

    public Company updateCompany(Company company) {
        Company companyToUpdate = companyRepository.findById( company.getId() ).orElse(null);

        companyToUpdate.setCpus(company.getCpus());
        companyToUpdate.setName(company.getName());

        return companyRepository.save(companyToUpdate);
    }

    public Cpu updateCpu(Cpu cpu) {
        Cpu cpuToUpdate = cpuRepository.findById( cpu.getId() ).orElse(null);

        cpuToUpdate.setCompatibleMobos(cpu.getCompatibleMobos());
        cpuToUpdate.setName(cpu.getName());
        cpuToUpdate.setSpecification(cpu.getSpecification());

        return cpuRepository.save(cpuToUpdate);
    }

    public Company deleteCompany(Company company) {
        companyRepository.deleteById(company.getId());
        return company;
    }

    public Cpu deleteCpu(Cpu cpu) {
        cpuRepository.deleteById(cpu.getId());
        return cpu;
    }









}
