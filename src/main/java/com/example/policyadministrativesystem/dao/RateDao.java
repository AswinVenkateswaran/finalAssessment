package com.example.policyadministrativesystem.dao;
import com.example.policyadministrativesystem.entity.Rate;

public interface RateDao {

    Rate findRate(String coverage, String state);
}
