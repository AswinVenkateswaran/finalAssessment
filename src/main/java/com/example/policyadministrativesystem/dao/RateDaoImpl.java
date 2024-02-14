package com.example.policyadministrativesystem.dao;

import com.example.policyadministrativesystem.entity.Rate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RateDaoImpl implements RateDao {

    @Autowired
    private EntityManager entityManager;

    public RateDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public Rate findRate(String coverage, String State) {
        TypedQuery<Rate> typedQuery = entityManager.createQuery("from Rate where coverage = '" + coverage + "' and state = '"  + State + "' ", Rate.class);
        Rate rate = typedQuery.getSingleResult();
        return rate;
    }
}
