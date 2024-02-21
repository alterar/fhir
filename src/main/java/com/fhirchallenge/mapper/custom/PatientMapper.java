package com.fhirchallenge.mapper.custom;

import com.fhirchallenge.data.vo.v2.PatientVOV2;
import org.springframework.stereotype.Service;
import com.fhirchallenge.model.Patient;

import java.util.Date;

@Service
public class PatientMapper {
    public PatientVOV2 convertEntityToVo(Patient patient) {
        PatientVOV2 vo = new PatientVOV2();
        vo.setId(patient.getId());
        vo.setFhirId(patient.getFhirId());
        vo.setLastName(patient.getLastName());
        vo.setFirstName(patient.getFirstName());
        vo.setBirthDay(new Date());
        return vo;
    }

    public Patient convertVoToEntity(PatientVOV2 patient) {
        Patient entity = new Patient();
        entity.setId(patient.getId());
        entity.setFhirId(patient.getFhirId());
        entity.setLastName(patient.getLastName());
        entity.setFirstName(patient.getFirstName());
        return entity;
    }
}
