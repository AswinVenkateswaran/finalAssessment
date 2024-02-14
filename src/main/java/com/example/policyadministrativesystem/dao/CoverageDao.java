package com.example.policyadministrativesystem.dao;

import com.example.policyadministrativesystem.entity.Coverage;

import java.util.List;

public interface CoverageDao {

    List<Coverage> findAll();
    Coverage findById(int id);
}
