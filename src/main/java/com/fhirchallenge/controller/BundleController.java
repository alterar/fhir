package com.fhirchallenge.controller;

import com.fhirchallenge.data.vo.fhir.EncounterVo;
import com.fhirchallenge.data.vo.v1.BundleVO;
import com.fhirchallenge.data.vo.v1.PatientVO;
import com.fhirchallenge.services.BundleService;
import com.fhirchallenge.services.PatientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.logging.Logger;

import java.util.List;

@RestController
@RequestMapping("/api/bundle/v1")
@Tag(name = "Bundle")
public class BundleController {
    @Autowired
    private BundleService service;

    @Autowired
    private PatientService patientService;

    private Logger logger = Logger.getLogger(BundleService.class.getName());

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BundleVO> findByPatient(@PathVariable(value = "id") Long id) {
        return service.findByPatient(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BundleVO> findAll() {
        return service.findAll();
    }


    @GetMapping(value = "/fhir/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PatientVO findByFhir(@PathVariable(value = "id") Long id) {
        var pvo = patientService.findById(id);
        var servi = service.findByPatient(id);

        ArrayList<EncounterVo> str = new ArrayList<EncounterVo>();
        RestTemplate restTemplate = new RestTemplate();

        for (int i = 0; i < servi.size(); i++) {
            logger.info(servi.get(i).getFhirBundleId());
            ResponseEntity<EncounterVo> resp = restTemplate.getForEntity(String.format("http://hapi.fhir.org/baseR4/Encounter/%s/_history/1", servi.get(i).getFhirBundleId()), EncounterVo.class);
            str.add(resp.getBody());
        }
        pvo.setEncounterVo(str);

        return pvo;
    }
}
