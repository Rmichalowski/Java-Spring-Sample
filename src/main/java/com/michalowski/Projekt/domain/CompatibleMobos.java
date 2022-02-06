package com.michalowski.Projekt.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.michalowski.Projekt.domain.Cpu;

@Entity
public class CompatibleMobos {
    private Long id;
    @NotEmpty
    @Size(min=1,max=255)
    private String name;

    @Size(min=1,max=255)
    private String manufacturer;
    @JsonIgnore
    private List<Cpu> cpus;


    public CompatibleMobos() {
    }

    public CompatibleMobos(String name, String manufacturer) {
        this.name = name;
        this.manufacturer = manufacturer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id;}

    public CompatibleMobos(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @ManyToMany(mappedBy = "compatibleMobos")
    public List<Cpu> getCpus() {return cpus;}

    public void setCpus(List<Cpu> cpus) {
        this.cpus = cpus;
    }
}
