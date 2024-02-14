package com.example.policyadministrativesystem.service;

import com.example.policyadministrativesystem.entity.Coverage;

import java.util.List;

public interface CoverageService {

    List<Coverage> getAllCoverages();

    Coverage getCoverage(int id);

}
