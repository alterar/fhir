package com.fhirchallenge.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.logging.Logger;

import com.fhirchallenge.data.vo.v1.PatientVO;
import com.fhirchallenge.data.vo.v2.PatientVOV2;
import com.fhirchallenge.exception.ResourceNotFoundException;
import com.fhirchallenge.mapper.DozerMapper;
import com.fhirchallenge.mapper.custom.PatientMapper;
import com.fhirchallenge.model.Patient;
import com.fhirchallenge.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PatientRepository repository;

    @Autowired
    PatientMapper mapper;

    private Logger logger = Logger.getLogger(PatientService.class.getName());

    public List<PatientVO> findAll() {
        logger.info("Todos os pacientes");

        return DozerMapper.parseListObjects(repository.findAll(), PatientVO.class) ;
    }

    public PatientVO findById(Long id) {
        logger.info("Procurando paciente por ID: " + id);

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado!"));

        var vo = DozerMapper.parseObject(entity, PatientVO.class);
        logger.info(vo.getFhirId());

        return vo;
    }

    public PatientVO create(PatientVO patient) {
        logger.info("Criando paciente");

        var entity = DozerMapper.parseObject(patient, Patient.class);
        return DozerMapper.parseObject(repository.save(entity), PatientVO.class);
    }

    public PatientVOV2 createV2(PatientVOV2 patient) {
        logger.info("Criando paciente V2");

        var entity = mapper.convertVoToEntity(patient);
        return mapper.convertEntityToVo(repository.save(entity));
    }

    public PatientVO update(PatientVO patient) {
        logger.info("Update paciente");

        var entity = repository.findById(patient.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado!"));

        entity.setFirstName(patient.getFirstName());
        entity.setLastName(patient.getLastName());
        entity.setFhirId(patient.getFhirId());

        return DozerMapper.parseObject(repository.save(entity), PatientVO.class);
    }

    public void delete(Long id) {
        logger.info("Deletando paciente por ID: " + id);

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado!"));

        repository.delete(entity);
    }
}
