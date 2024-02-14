package com.example.policyadministrativesystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class State {

    @Id
    private int sid;
    private String stateName;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
