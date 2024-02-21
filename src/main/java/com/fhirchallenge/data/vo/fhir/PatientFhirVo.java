package com.fhirchallenge.data.vo.fhir;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientFhirVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String resourceType;
    private String id;
    private MetaVo meta;
    private TextVo text;

    @JsonProperty(value = "identifier")
    private ArrayList<IdentifierVo> identifiers;

    @JsonProperty(value = "name")
    private ArrayList<NameVo> names;

    private String gender;

    @JsonProperty(value = "address")
    private ArrayList<AddressVo> addresses;

    @JsonProperty(value = "contact")
    private ArrayList<ContactVo> contacts;

    public PatientFhirVo() {
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MetaVo getMeta() {
        return meta;
    }

    public void setMeta(MetaVo meta) {
        this.meta = meta;
    }

    public TextVo getText() {
        return text;
    }

    public void setText(TextVo text) {
        this.text = text;
    }

    public ArrayList<IdentifierVo> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(ArrayList<IdentifierVo> identifiers) {
        this.identifiers = identifiers;
    }

    public ArrayList<NameVo> getNames() {
        return names;
    }

    public void setNames(ArrayList<NameVo> names) {
        this.names = names;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<AddressVo> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<AddressVo> addresses) {
        this.addresses = addresses;
    }

    public ArrayList<ContactVo> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<ContactVo> contacts) {
        this.contacts = contacts;
    }

    @Override
    public int hashCode() {
        return Objects.hash(addresses, contacts, gender, id, identifiers, meta, names, resourceType, text);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PatientFhirVo other = (PatientFhirVo) obj;
        return Objects.equals(addresses, other.addresses) && Objects.equals(contacts, other.contacts) && Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
                && Objects.equals(identifiers, other.identifiers) && Objects.equals(meta, other.meta) && Objects.equals(names, other.names) && Objects.equals(resourceType, other.resourceType)
                && Objects.equals(text, other.text);
    }

}
