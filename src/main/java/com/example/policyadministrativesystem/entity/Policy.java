package com.example.policyadministrativesystem.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int policyNo;
    private String policyHolderName;
    private String status;
    private String Addressline1;
    private String Addressline2;

    private int preminumAmount;
    @ManyToOne( cascade = {CascadeType.PERSIST,  CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private State state;

    @ManyToMany(cascade = {CascadeType.PERSIST,  CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Coverage> coverages;

    public int getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(int policyNo) {
        this.policyNo = policyNo;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddressline1() {
        return Addressline1;
    }

    public void setAddressline1(String addressline1) {
        Addressline1 = addressline1;
    }

    public String getAddressline2() {
        return Addressline2;
    }

    public void setAddressline2(String addressline2) {
        Addressline2 = addressline2;
    }

    public int getPreminumAmount() {
        return preminumAmount;
    }

    public void setPreminumAmount(int preminumAmount) {
        this.preminumAmount = preminumAmount;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Coverage> getCoverages() {
        return coverages;
    }

    public void setCoverages(List<Coverage> coverages) {
        this.coverages = coverages;
    }
}
