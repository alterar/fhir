package com.fhirchallenge.repository;

import com.fhirchallenge.model.Bundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BundleRepository extends JpaRepository<Bundle, Long> {

    @Query(value = "select * from bundle where patient = :id and tipo = 'Encounter'", nativeQuery = true)
    List<Bundle> findByPatient(Long id);
}