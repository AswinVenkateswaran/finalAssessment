package com.example.policyadministrativesystem.service;


import com.example.policyadministrativesystem.entity.Rate;

public interface RateService {

    Rate getRate(String coverage, String state);
}
