package com.fhirchallenge.data.vo.fhir;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NameVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String use;
    private String family;
    private ArrayList<String> given;

    public NameVo() {
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public ArrayList<String> getGiven() {
        return given;
    }

    public void setGiven(ArrayList<String> given) {
        this.given = given;
    }

    @Override
    public int hashCode() {
        return Objects.hash(family, given, use);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NameVo other = (NameVo) obj;
        return Objects.equals(family, other.family) && Objects.equals(given, other.given) && Objects.equals(use, other.use);
    }

}
