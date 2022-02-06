package com.michalowski.Projekt.domain;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.*;

@Entity
public class Company {
    private Long id;
    @NotEmpty
    @Size(min=1,max=255)
    private String name;
    private List<Cpu> cpus;


    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {
        return name;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Cpu> getCpus() {return cpus; }


    public void setName(String name) {
        this.name = name;
    }

    public void setCpus(List<Cpu> cpus) {this.cpus = cpus; }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpus=" + cpus +
                '}';
    }
}
