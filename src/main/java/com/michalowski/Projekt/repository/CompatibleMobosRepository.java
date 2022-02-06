package com.michalowski.Projekt.repository;

import com.michalowski.Projekt.domain.CompatibleMobos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.michalowski.Projekt.domain.CompatibleMobos;

@Repository
public interface CompatibleMobosRepository extends CrudRepository<CompatibleMobos, Long> {
    CompatibleMobos findByManufacturer(String manufacturer);
    CompatibleMobos findByName(String name);
}
