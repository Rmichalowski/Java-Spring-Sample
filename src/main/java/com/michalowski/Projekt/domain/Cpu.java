package com.michalowski.Projekt.domain;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.*;

@Entity
public class Cpu {

    private Long id;
    @NotEmpty
    @Size(min=1,max=255)
    private String name;
    private Specification specification;
    private List<CompatibleMobos> compatibleMobos;


    public Cpu(String name) {
        this.name = name;
    }

    public Cpu() {}

    public Cpu(String name, Specification specification, List<CompatibleMobos> compatibleMobos) {
        this.name = name;
        this.specification = specification;
        this.compatibleMobos = compatibleMobos;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id; }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(cascade = CascadeType.MERGE)
    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public List<CompatibleMobos> getCompatibleMobos() {
        return compatibleMobos;
    }

    public void setCompatibleMobos(List<CompatibleMobos> compatibleMobos) {
        this.compatibleMobos = compatibleMobos;
    }
}
