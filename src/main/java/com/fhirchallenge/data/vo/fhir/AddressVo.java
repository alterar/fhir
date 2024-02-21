package com.fhirchallenge.data.vo.fhir;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String use;
    private String text;
    private String city;
    private String state;
    private String postalCode;

    public AddressVo() {
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, postalCode, state, text, use);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AddressVo other = (AddressVo) obj;
        return Objects.equals(city, other.city) && Objects.equals(postalCode, other.postalCode) && Objects.equals(state, other.state) && Objects.equals(text, other.text) && Objects.equals(use, other.use);
    }

}
