package com.fhirchallenge.data.vo.fhir;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String relation;
    private String url;

    public LinkVo() {
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkVo linkVo = (LinkVo) o;
        return Objects.equals(relation, linkVo.relation) && Objects.equals(url, linkVo.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(relation, url);
    }
}
