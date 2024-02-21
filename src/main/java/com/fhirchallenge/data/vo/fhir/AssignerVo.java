package com.fhirchallenge.data.vo.fhir;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignerVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String display;

    public AssignerVo() {
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public int hashCode() {
        return Objects.hash(display);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AssignerVo other = (AssignerVo) obj;
        return Objects.equals(display, other.display);
    }

}
