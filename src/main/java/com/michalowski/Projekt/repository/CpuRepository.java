package com.michalowski.Projekt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.michalowski.Projekt.domain.Cpu;

@Repository
public interface CpuRepository extends CrudRepository<Cpu, Long> {
}
