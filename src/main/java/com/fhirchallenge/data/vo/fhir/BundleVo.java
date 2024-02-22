package com.fhirchallenge.data.vo.fhir;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BundleVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String resourceType;
    private String id;
    private MetaVo meta;

    private String type;
    private int total;
    private ArrayList<LinkVo> link;

    public BundleVo() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<LinkVo> getLink() {
        return link;
    }

    public void setLink(ArrayList<LinkVo> link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BundleVo bundleVo = (BundleVo) o;
        return total == bundleVo.total && Objects.equals(resourceType, bundleVo.resourceType) && Objects.equals(id, bundleVo.id) && Objects.equals(meta, bundleVo.meta) && Objects.equals(type, bundleVo.type) && Objects.equals(link, bundleVo.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceType, id, meta, type, total, link);
    }
}
