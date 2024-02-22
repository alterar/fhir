package com.fhirchallenge.services;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.logging.Logger;

import com.fhirchallenge.data.vo.v1.BundleVO;
import com.fhirchallenge.exception.ResourceNotFoundException;
import com.fhirchallenge.mapper.DozerMapper;
import com.fhirchallenge.mapper.custom.PatientMapper;
import com.fhirchallenge.model.Bundle;
import com.fhirchallenge.repository.BundleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BundleService {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    BundleRepository repository;

    @Autowired
    PatientMapper mapper;

    private Logger logger = Logger.getLogger(BundleService.class.getName());

    public List<BundleVO> findAll() {
        logger.info("Todos os bundle");

        return DozerMapper.parseListObjects(repository.findAll(), BundleVO.class) ;
    }

    public List<BundleVO> findByPatient(Long id) {
        logger.info("Procurando bundle por paciente: " + id);

        var entity = repository.findByPatient(id);

        return DozerMapper.parseListObjects(entity, BundleVO.class);
    }

    public BundleVO create(BundleVO patient) {
        logger.info("Criando paciente");

        var entity = DozerMapper.parseObject(patient, Bundle.class);
        return DozerMapper.parseObject(repository.save(entity), BundleVO.class);
    }

}