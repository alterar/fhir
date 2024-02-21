package com.fhirchallenge.controller;

import java.util.List;

import com.fhirchallenge.data.vo.fhir.PatientFhirVo;
import com.fhirchallenge.data.vo.v1.PatientVO;
import com.fhirchallenge.data.vo.v2.PatientVOV2;
import com.fhirchallenge.services.PatientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/patient/v1")
@Tag(name = "Patient")
public class PatientController {
    @Autowired
    private PatientService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PatientVO findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PatientVO> findAll() {
        return service.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PatientVO create(@RequestBody PatientVO patient) {
        return service.create(patient);
    }

    @PostMapping(value = "/v2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PatientVOV2 createV2(@RequestBody PatientVOV2 patient) {
        return service.createV2(patient);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PatientVO update(@RequestBody PatientVO patient) {
        return service.update(patient);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable (value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/fhir/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PatientFhirVo findByFhir(@PathVariable(value = "id") Long id) {
        var servi = service.findById(id);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PatientFhirVo> resp = restTemplate.getForEntity(String.format("http://hapi.fhir.org/baseR4/Patient/%s", servi.getFhirId()), PatientFhirVo.class);
        return resp.getBody();
    }
}
