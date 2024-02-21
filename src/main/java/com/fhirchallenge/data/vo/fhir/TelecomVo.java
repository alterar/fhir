package com.fhirchallenge.data.vo.fhir;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TelecomVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String system;
    private String value;
    private String use;
    private int rank;

    public TelecomVo() {
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, system, use, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TelecomVo other = (TelecomVo) obj;
        return rank == other.rank && Objects.equals(system, other.system) && Objects.equals(use, other.use) && Objects.equals(value, other.value);
    }

}
