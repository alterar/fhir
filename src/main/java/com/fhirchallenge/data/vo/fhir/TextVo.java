package com.fhirchallenge.data.vo.fhir;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TextVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String status;
    private String div;

    public TextVo() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDiv() {
        return div;
    }

    public void setDiv(String div) {
        this.div = div;
    }

    @Override
    public int hashCode() {
        return Objects.hash(div, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TextVo other = (TextVo) obj;
        return Objects.equals(div, other.div) && Objects.equals(status, other.status);
    }

}
