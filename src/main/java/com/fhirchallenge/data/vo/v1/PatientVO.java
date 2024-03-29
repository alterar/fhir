package com.fhirchallenge.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fhirchallenge.data.vo.fhir.EncounterVo;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = "patient")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class PatientVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sobrenome", nullable = false)
    private String lastName;

    @Column(name = "nome", nullable = false)
    private String firstName;

    @Column(name = "fhirid")
    private String fhirId;

    public PatientVO() {
    }

    public String getFhirId() {
        return fhirId;
    }

    public void setFhirId(String fhirId) {
        this.fhirId = fhirId;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public ArrayList<com.fhirchallenge.data.vo.fhir.EncounterVo> getEncounterVo() {
        return Encounter;
    }

    public void setEncounterVo(ArrayList<com.fhirchallenge.data.vo.fhir.EncounterVo> encounter) {
        Encounter = encounter;
    }

    private ArrayList<EncounterVo> Encounter;


}
