package com.michalowski.Projekt.domain;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Specification {
    private Long id;
    @NotNull
    @Range(min=100, max=10000)
    private int frequency;
    @NotNull
    @Range(min=1, max=256)
    private int cores;
    @NotNull
    @Range(min=5, max=1000)
    private int tdp;

    public Specification() {}

    public Specification(int frequency, int cores, int tdp) {
        this.frequency = frequency;
        this.cores = cores;
        this.tdp = tdp;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id;}

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public int getTdp() {
        return tdp;
    }

    public void setTdp(int tdp) {
        this.tdp = tdp;
    }
}
