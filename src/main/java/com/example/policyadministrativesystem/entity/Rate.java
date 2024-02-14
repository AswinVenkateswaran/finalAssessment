package com.example.policyadministrativesystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Rate {

    @Id
    private int rateid;
    private String coverage;
    private String state;
    private int rate;

    public int getId() {
        return rateid;
    }

    public void setId(int id) {
        this.rateid = id;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
