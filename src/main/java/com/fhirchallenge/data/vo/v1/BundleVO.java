package com.fhirchallenge.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fhirchallenge.data.vo.fhir.EncounterVo;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "bundle")
public class BundleVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fhirbundleid")
    private String fhirBundleId;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "patient")
    private Long patient;

    public BundleVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFhirBundleId() {
        return fhirBundleId;
    }

    public void setFhirBundleId(String fhirBundleId) {
        this.fhirBundleId = fhirBundleId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getPatient() {
        return patient;
    }

    public void setPatient(Long patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BundleVO bundleVO = (BundleVO) o;
        return Objects.equals(id, bundleVO.id) && Objects.equals(fhirBundleId, bundleVO.fhirBundleId) && Objects.equals(tipo, bundleVO.tipo) && Objects.equals(patient, bundleVO.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fhirBundleId, tipo, patient);
    }
}
