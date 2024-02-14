package com.example.policyadministrativesystem.service;

import com.example.policyadministrativesystem.dao.CoverageDaoImpl;
import com.example.policyadministrativesystem.entity.Coverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoverageServiceImpl implements CoverageService {

    @Autowired
    private CoverageDaoImpl coverageDao;
    @Override
    public List<Coverage> getAllCoverages() {
        return coverageDao.findAll();
    }

    @Override
    public Coverage getCoverage(int id) {
        return coverageDao.findById(id);
    }


}
