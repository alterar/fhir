package com.fhirchallenge.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "bundle")
public class Bundle implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient")
    private Long patient;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "fhirbundleid")
    private String fhirBundleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatient() {
        return patient;
    }

    public void setPatient(Long patient) {
        this.patient = patient;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFhirBundleId() {
        return fhirBundleId;
    }

    public void setFhirBundleId(String fhirBundleId) {
        this.fhirBundleId = fhirBundleId;
    }

    public Bundle() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bundle bundle = (Bundle) o;
        return Objects.equals(id, bundle.id) && Objects.equals(patient, bundle.patient) && Objects.equals(tipo, bundle.tipo) && Objects.equals(fhirBundleId, bundle.fhirBundleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, tipo, fhirBundleId);
    }
}
