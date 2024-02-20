package com.fhirchallenge.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.logging.Logger;

import com.fhirchallenge.exception.ResourceNotFoundException;
import com.fhirchallenge.model.Patient;
import com.fhirchallenge.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PatientRepository repository;

    private Logger logger = Logger.getLogger(PatientService.class.getName());

    public Patient findById(Long id) {
        logger.info("Procurando paciente por ID: " + id);

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado!"));
    }

    public List<Patient> findAll() {
        logger.info("Returning all");

        return repository.findAll();
    }

    public Patient create(Patient patient) {
        logger.info("Criando paciente");

        return repository.save(patient);
    }

    public Patient update(Patient patient) {
        logger.info("Update paciente");

        Patient entity = repository.findById(patient.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado!"));

        entity.setFirstName(patient.getFirstName());
        entity.setLastName(patient.getLastName());
        entity.setFhirId(patient.getFhirId());

        return repository.save(patient);
    }

    public Patient delete(Long id) {
        logger.info("Deletando paciente by ID: " + id);

        Patient entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado!"));

        repository.delete(entity);

        return null;
    }
}
