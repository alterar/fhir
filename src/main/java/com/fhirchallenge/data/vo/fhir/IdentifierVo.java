package com.fhirchallenge.data.vo.fhir;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class IdentifierVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String use;
    private String value;
    private AssignerVo assigner;

    public IdentifierVo() {
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public AssignerVo getAssigner() {
        return assigner;
    }

    public void setAssigner(AssignerVo assigner) {
        this.assigner = assigner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(assigner, use, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IdentifierVo other = (IdentifierVo) obj;
        return Objects.equals(assigner, other.assigner) && Objects.equals(use, other.use) && Objects.equals(value, other.value);
    }

}
