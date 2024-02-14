package com.example.policyadministrativesystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Coverage {

    @Id
    private int cid;
    private String coverageName;

    @ManyToMany(mappedBy = "coverages")
    private List<Policy> policys;
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCoverageName() {
        return coverageName;
    }

    public void setCoverageName(String coverageName) {
        this.coverageName = coverageName;
    }
}
