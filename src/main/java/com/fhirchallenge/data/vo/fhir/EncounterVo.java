package com.fhirchallenge.data.vo.fhir;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class EncounterVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String resourceType;
    private String id;
    private MetaVo meta;
    @JsonProperty(value = "identifier")
    private ArrayList<IdentifierVo> identifiers;

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

    public ArrayList<IdentifierVo> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(ArrayList<IdentifierVo> identifiers) {
        this.identifiers = identifiers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SubjectVo getSubject() {
        return subject;
    }

    public void setSubject(SubjectVo subject) {
        this.subject = subject;
    }

    private String status;

    private SubjectVo subject;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncounterVo that = (EncounterVo) o;
        return Objects.equals(resourceType, that.resourceType) && Objects.equals(id, that.id) && Objects.equals(meta, that.meta) && Objects.equals(identifiers, that.identifiers) && Objects.equals(status, that.status) && Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceType, id, meta, identifiers, status, subject);
    }
}
