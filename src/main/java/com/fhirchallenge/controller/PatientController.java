package com.fhirchallenge.controller;

import java.util.List;


import com.fhirchallenge.data.vo.fhir.BundleVo;
import com.fhirchallenge.data.vo.fhir.PatientFhirVo;
import com.fhirchallenge.data.vo.v1.BundleVO;
import com.fhirchallenge.data.vo.v1.PatientVO;
import com.fhirchallenge.data.vo.v2.PatientVOV2;
import com.fhirchallenge.services.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/patient/v1")
@Tag(name = "Patient", description = "Endpoints para paciente")
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

    @GetMapping(value = "/fhir/patient/{urn}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Busca paciente pelo identificador urn:uh-patient-id;", description = "Retorna informação Fhir de paciente pelo identificador urn:uh-patient-id;", tags = { "Bundle" }, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BundleVO.class))),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content), @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content), @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
    public BundleVo findByPatientUrn(@PathVariable(value = "urn") String urn) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BundleVo> resp = restTemplate.getForEntity(String.format("https://hapi.fhir.org/baseR4/Patient?identifier=urn:uh-patient-id|%s", urn), BundleVo.class);
        return resp.getBody();
    }
}
