package com.fhirchallenge.data.vo.fhir;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<TelecomVo> telecom;

    public ContactVo() {
    }

    public ArrayList<TelecomVo> getTelecom() {
        return telecom;
    }

    public void setTelecom(ArrayList<TelecomVo> telecom) {
        this.telecom = telecom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(telecom);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContactVo other = (ContactVo) obj;
        return Objects.equals(telecom, other.telecom);
    }

}
