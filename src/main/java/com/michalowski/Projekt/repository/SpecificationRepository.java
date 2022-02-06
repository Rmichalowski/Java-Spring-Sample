package com.michalowski.Projekt.repository;

import com.michalowski.Projekt.domain.Company;
import com.michalowski.Projekt.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import com.michalowski.Projekt.domain.Specification;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecificationRepository extends CrudRepository<Specification, Long> {
}
