package com.michalowski.Projekt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.michalowski.Projekt.domain.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
}

