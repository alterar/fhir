package com.fhirchallenge.controller;

import com.fhirchallenge.data.vo.fhir.BundleVo;
import com.fhirchallenge.data.vo.fhir.EncounterVo;
import com.fhirchallenge.data.vo.v1.BundleVO;
import com.fhirchallenge.data.vo.v1.PatientVO;
import com.fhirchallenge.services.BundleService;
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

import java.util.ArrayList;
import java.util.logging.Logger;

import java.util.List;

@RestController
@RequestMapping("/api/bundle/v1")
@Tag(name = "Bundle", description = "Endpoints para bundles")
public class BundleController {
    @Autowired
    private BundleService service;

    @Autowired
    private PatientService patientService;

    private Logger logger = Logger.getLogger(BundleService.class.getName());

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Busca recursos de consulta pelo id", description = "Busca recursos de consulta pelo id", tags = { "Bundle" }, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BundleVO.class))),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content), @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content), @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
    public List<BundleVO> findByPatient(@PathVariable(value = "id") Long id) {
        return service.findByPatient(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Busca recursos", description = "Busca recursos", tags = { "Bundle" }, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BundleVO.class))),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content), @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content), @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
    public List<BundleVO> findAll() {
        return service.findAll();
    }


    @GetMapping(value = "/fhir/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Busca recursos fhir de consulta pelo id", description = "Retorna informação Fhir das consultas pelo id", tags = { "Bundle" }, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BundleVO.class))),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content), @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content), @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
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

    @GetMapping(value = "/fhir/bundle/{urn}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Busca encounter pelo identificador urn:uh-encounter-id;", description = "Retorna informação Fhir das consultas pelo identificador urn:uh-encounter-id;", tags = { "Bundle" }, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BundleVO.class))),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content), @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content), @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
    public BundleVo findByUrn(@PathVariable(value = "urn") String urn) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BundleVo> resp = restTemplate.getForEntity(String.format("https://hapi.fhir.org/baseR4/Encounter?identifier=urn:uh-encounter-id|%s", urn), BundleVo.class);
        return resp.getBody();
    }
}
