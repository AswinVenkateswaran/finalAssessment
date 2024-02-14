package com.example.policyadministrativesystem.service;

import com.example.policyadministrativesystem.dao.RateDaoImpl;
import com.example.policyadministrativesystem.entity.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl implements RateService {

    private RateDaoImpl rateDao;
    @Autowired
    public RateServiceImpl(RateDaoImpl rateDao){
        this.rateDao = rateDao;
    }
    @Override
    public Rate getRate(String coverage, String state) {
        return rateDao.findRate(coverage,state);
    }
}
