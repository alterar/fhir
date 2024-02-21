package com.fhirchallenge.data.vo.fhir;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String reference;
    private String type;

    public String getReference() {
        return reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectVo subjectVo = (SubjectVo) o;
        return Objects.equals(reference, subjectVo.reference) && Objects.equals(type, subjectVo.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, type);
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
